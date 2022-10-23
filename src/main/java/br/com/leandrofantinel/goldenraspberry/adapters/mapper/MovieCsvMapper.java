package br.com.leandrofantinel.goldenraspberry.adapters.mapper;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.csv.movie.MovieCsv;
import br.com.leandrofantinel.goldenraspberry.core.model.Movie;
import br.com.leandrofantinel.goldenraspberry.core.model.Producer;
import br.com.leandrofantinel.goldenraspberry.core.model.Studio;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MovieCsvMapper extends MapperUtil<MovieCsv, Movie> {

    public MovieCsvMapper(ObjectMapper mapper) {
        super(MovieCsv.class, Movie.class, mapper);
    }

    @Override
    public Movie convert(MovieCsv obj) {
        return super.convert(obj, (from,to) -> {
            /*Producers*/
            String[] vet = from.getProducers().split("(,)|(\\sand\\s)");
            Set<Producer> producers = Stream.of(vet).filter(e -> e != null && !e.isBlank())
                    .map(e -> {
                        final String name = e.trim();
                        return getInstance(name, Producer.class, () -> new Producer(name));
                    }).collect(Collectors.toSet());
            to.setProducers(producers);

            /*Studios*/
            vet = from.getStudios().split("(,)|(and)");
            Set<Studio> studios = Stream.of(vet).filter(e -> e != null && !e.isBlank())
                    .map(e -> {
                        final String name = e.trim();
                        return getInstance(name, Studio.class, () -> new Studio(name));
                    }).collect(Collectors.toSet());
            to.setStudios(studios);
        });
    }

    @Override
    public MovieCsv revert(Movie obj) {
        return super.revert(obj, (to, from) -> {
            from.setProducers(String.join(from.getProducers()));
            from.setStudios(String.join(from.getStudios()));
        });
    }

}
