package br.com.leandrofantinel.goldenraspberry.adapters.datasource;

import br.com.leandrofantinel.goldenraspberry.core.port.out.GenericDatasourcePort;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

interface GenericDatasource<M, E> extends GenericDatasourcePort<M> {

    <Rep extends JpaRepository<E, Integer>> Rep getRepository();

    <Map extends MapperUtil<M,E>> Map getMapper();

    default List<M> findAll() {
        return getMapper().revert(getRepository().findAll());
    }
    default M findById(Integer id) {
        return getMapper().revert(getRepository().findById(id).orElse(null));
    }

    default M save(M obj) {
        E transientObj = getMapper().convert(obj);
        E persistentObj = getRepository().saveAndFlush(transientObj);
        return getMapper().revert(persistentObj);
    }
    default List<M> saveAll(List<M> list) {
        List<E> transientList = getMapper().convert(list);
        List<E> persistentList = getRepository().saveAll(Objects.requireNonNull(transientList));
        return getMapper().revert(persistentList);
    }

    default void deleteById(Integer id) {
        getRepository().deleteById(id);
    }
}
