package br.com.leandrofantinel.goldenraspberry.core.port.out;

import java.util.List;

public interface GenericDatasourcePort<M> {
    M findById(Integer id);
    List<M> findAll();
    M save(M obj);
    List<M> saveAll(List<M> list);
    void deleteById(Integer id);
}
