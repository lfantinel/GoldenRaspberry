package br.com.leandrofantinel.goldenraspberry.adapters.datasource;

import br.com.leandrofantinel.goldenraspberry.adapters.mapper.MovieCsvMapper;
import br.com.leandrofantinel.goldenraspberry.adapters.mapper.MovieMapper;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie.MovieCsv;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie.MovieCsvRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.MovieRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.MovieEntity;
import br.com.leandrofantinel.goldenraspberry.core.model.Movie;
import br.com.leandrofantinel.goldenraspberry.core.port.in.LoadMoviesFile;
import br.com.leandrofantinel.goldenraspberry.core.port.out.MovieDatasourcePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
class MovieDatasourceImpl
        implements MovieDatasourcePort, LoadMoviesFile,
        GenericDatasource<Movie, MovieEntity> {

    private final MovieCsvRepository csvRepository;
    private final MovieCsvMapper csvMapper;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<Movie> loadCsv(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        List<MovieCsv> source = csvRepository.load(is);
        return csvMapper.convert(source);
    }

    @Override
    public MovieRepository getRepository() {
        return movieRepository;
    }

    @Override
    public MovieMapper getMapper() {
        return movieMapper;
    }

}
