package br.com.leandrofantinel.goldenraspberry.adapters.datasource;

import br.com.leandrofantinel.goldenraspberry.adapters.mapper.MovieCsvMapper;
import br.com.leandrofantinel.goldenraspberry.adapters.mapper.MovieMapper;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie.MovieCsv;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie.MovieCsvRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.MovieRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.StudioRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.MovieEntity;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.StudioEntity;
import br.com.leandrofantinel.goldenraspberry.core.model.Movie;
import br.com.leandrofantinel.goldenraspberry.core.model.Studio;
import br.com.leandrofantinel.goldenraspberry.core.port.in.LoadMoviesFile;
import br.com.leandrofantinel.goldenraspberry.core.port.out.MovieDataStore;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
class MovieDatastoreImpl implements MovieDataStore, LoadMoviesFile {

    private final MovieCsvRepository csvRepository;
    private final MovieCsvMapper csvMapper;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final StudioRepository studioRepository;
    private final MapperUtil<Studio, StudioEntity> studioMapper;
    @Override
    public List<Movie> loadCsv(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        List<MovieCsv> source = csvRepository.load(is);
        return csvMapper.convert(source);
    }

    @Override
    public List<Movie> save(List<Movie> list) {
        List<MovieEntity> transientList = movieMapper.convert(list);
        List<MovieEntity> persistentList = movieRepository.saveAll(Objects.requireNonNull(transientList));
        return movieMapper.revert(persistentList);
    }
}
