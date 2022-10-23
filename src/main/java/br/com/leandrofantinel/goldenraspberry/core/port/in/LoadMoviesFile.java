package br.com.leandrofantinel.goldenraspberry.core.port.in;

import br.com.leandrofantinel.goldenraspberry.core.model.Movie;

import java.util.List;

public interface LoadMoviesFile {
    List <Movie> loadCsv(String fileName);
}
