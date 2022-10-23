package br.com.leandrofantinel.goldenraspberry.adapters.web;

import br.com.leandrofantinel.goldenraspberry.core.port.out.GenericDatasourcePort;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

interface AbstractController<M> {
    GenericDatasourcePort<M> getDatasource();

    @ApiOperation("List all register.")
    @GetMapping(path = "", produces = "application/json")
    default List<M> findAll() {
        return getDatasource().findAll();
    }

    @ApiOperation("Find one register by id.")
    @GetMapping(path = "{id}", produces = "application/json")
    default M findById(@PathVariable Integer id) {
        return getDatasource().findById(id);
    }

    @ApiOperation("Save a new register.")
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    default M save(M obj) {
        return getDatasource().save(obj);
    }


    @ApiOperation("Full update existent register.")
    @PutMapping(path = "", consumes = "application/json", produces = "application/json")
    default M update(M obj) {
        return getDatasource().save(obj);
    }

    @ApiOperation("Partial update existent register.")
    @PatchMapping(path = "", consumes = "application/json", produces = "application/json")
    default M patch(M obj) {
        return getDatasource().save(obj);
    }

    @ApiOperation("Delete register by id.")
    @DeleteMapping(path = "{id}", consumes = "application/json", produces = "application/json")
    default void deleteById(@PathVariable  Integer id) {
        getDatasource().deleteById(id);
    }
}
