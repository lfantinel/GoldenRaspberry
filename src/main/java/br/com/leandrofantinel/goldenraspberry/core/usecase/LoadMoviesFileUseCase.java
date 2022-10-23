package br.com.leandrofantinel.goldenraspberry.core.usecase;

import br.com.leandrofantinel.goldenraspberry.core.model.Movie;
import br.com.leandrofantinel.goldenraspberry.core.port.in.LoadMoviesFile;
import br.com.leandrofantinel.goldenraspberry.core.port.out.MovieDatasourcePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LoadMoviesFileUseCase {

    private final LoadMoviesFile csvDatastore;
    private final MovieDatasourcePort datastore;

    public void execute(String fileName) {
        List<Movie> list = csvDatastore.loadCsv(fileName);
        datastore.saveAll(list);
    }
}
