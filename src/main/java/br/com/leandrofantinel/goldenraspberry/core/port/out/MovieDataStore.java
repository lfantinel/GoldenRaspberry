package br.com.leandrofantinel.goldenraspberry.core.port.out;

import br.com.leandrofantinel.goldenraspberry.core.model.Movie;

import java.util.List;

public interface MovieDataStore {
    List<Movie> save(List<Movie> list);
}
