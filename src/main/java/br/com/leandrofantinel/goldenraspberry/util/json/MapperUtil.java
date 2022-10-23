package br.com.leandrofantinel.goldenraspberry.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InjectionPoint;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;



@Log4j2
public class MapperUtil <From, To> {

    private final ObjectMapper mapper;
    private final Class<From> classFrom;
    private final Class<To> classTo;

    private final Map<Class<?>, Map<String, Object>> mInstancePool = new HashMap<>();

    public MapperUtil(Class<From> classFrom, Class<To> classTo, ObjectMapper mapper) {
        this.mapper = mapper;
        this.classFrom = classFrom;
        this.classTo = classTo;
    }

    public MapperUtil(InjectionPoint ip, ObjectMapper mapper) {
        this.mapper = mapper;
        Type type = Objects.requireNonNull(ip.getMethodParameter())
                .getGenericParameterType();

        if (!(type instanceof ParameterizedType)) type = ((Class<?>) type).getGenericSuperclass();

        this.classFrom = (Class<From>) ((ParameterizedType)type).getActualTypeArguments()[0];
        this.classTo = (Class<To>) ((ParameterizedType)type).getActualTypeArguments()[1];

    }

    public final Map<String, Object> objToMap(Object obj) {
        try {
            return mapper.convertValue(obj, HashMap.class);
        } catch (Exception e) {
            log.error("Erro ao converter Objeto. {}", e.getMessage());
            return null;
        }
    }

    public final List<Map<String, Object>> listToMap(List<?> list) {
        try {
            return list.stream().map(this::objToMap).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Erro ao converter Lista. {}", e.getMessage());
            return null;
        }
    }

    protected  <S, D> D _convert(S from, Class<D> classTo) {
        try {
            return mapper.convertValue(objToMap(from), classTo);
        } catch (Exception e){
            log.error("Erro ao converter Objeto. {}", e.getMessage());
            return null;
        }
    }

    protected final To convert (From obj, BiConsumer<From, To> map) {
        To to = _convert(obj, classTo);
        if (map != null) map.accept(obj, to);
        return to;
    }
    public To convert (From obj) {
        return convert(obj, null);
    }

    protected final From revert (To obj, BiConsumer<To, From> map) {
        From from = _convert(obj, classFrom);
        if (map != null) map.accept(obj, from);
        return from;
    }

    public From revert (To obj) {
        return revert(obj, null);
    }

    public final List<To> convert (List<From> list, BiConsumer<From, To> map) {
        try {
            return list.stream().map(e -> convert(e, map)).collect(Collectors.toList());
        } catch (Exception e){
            log.error("Erro ao converter Lista. {}", e.getMessage());
            return null;
        }
    }

    public final List<To> convert (List<From> list) {
        try {
            return list.stream().map(this::convert).collect(Collectors.toList());
        } catch (Exception e){
            log.error("Erro ao converter Lista. {}", e.getMessage());
            return null;
        }
    }

    public final Set<To> convert (Set<From> list) {
        try {
            return list.stream().map(this::convert).collect(Collectors.toSet());
        } catch (Exception e){
            log.error("Erro ao converter Lista. {}", e.getMessage());
            return null;
        }
    }

    public final List<From> revert (List<To> list) {
        try {
            return list.stream().map(this::revert).collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
            log.error("Erro ao converter Lista. {}", e.getMessage());
            return null;
        }
    }

    protected <T> T getInstance(String key, Class<T> type, Supplier<T> supplier) {
        if (!mInstancePool.containsKey(type)) mInstancePool.put(type, new HashMap<>());
        Map<String, Object> instances = mInstancePool.get(type);
        if (!instances.containsKey(key)) instances.put(key, supplier.get());
        return (T) instances.get(key);
    }

}
