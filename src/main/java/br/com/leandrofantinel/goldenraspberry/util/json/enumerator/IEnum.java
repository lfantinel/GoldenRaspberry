package br.com.leandrofantinel.goldenraspberry.util.json.enumerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.stream.Stream;

public interface IEnum<ID> {
    String IEnumType = "";
    ID getId();
    String name();

    @JsonProperty
    default String value() {
        return  String.valueOf(getId());
    }

    static IEnum<?> valueOf(Class<IEnum<?>> type, Object value) {
        return Stream.of(type.getEnumConstants())
                .filter(e -> Objects.equals(e.value(), value))
                .findFirst().orElse(null);
    }
}
