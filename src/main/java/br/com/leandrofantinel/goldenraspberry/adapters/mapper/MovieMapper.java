package br.com.leandrofantinel.goldenraspberry.adapters.mapper;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.MovieEntity;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.ProducerEntity;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.StudioEntity;
import br.com.leandrofantinel.goldenraspberry.core.model.Movie;
import br.com.leandrofantinel.goldenraspberry.core.model.Producer;
import br.com.leandrofantinel.goldenraspberry.core.model.Studio;
import br.com.leandrofantinel.goldenraspberry.core.model.domain.Winner;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieMapper extends MapperUtil<Movie, MovieEntity> {

    public MovieMapper(ObjectMapper mapper) {
        super(Movie.class, MovieEntity.class, mapper);
    }

    @Override
    public MovieEntity convert(Movie obj) {
        return super.convert(obj, (from,to) -> {
            /*Studios*/
            Set<StudioEntity> studios = from.getStudios().stream().map(s -> {
                final String name = s.getName().trim();
                return getInstance(name, StudioEntity.class, () -> new StudioEntity(name));
            }).collect(Collectors.toSet());
            to.setStudios(studios);

            /*Producers*/
            Set<ProducerEntity> producers = from.getProducers().stream().map(producer -> {
                final String name = producer.getName().trim();
                return getInstance(name, ProducerEntity.class, () -> new ProducerEntity(name));
            }).collect(Collectors.toSet());
            to.setProducers(producers);

            to.setWinner(Winner.YES.equals(obj.getWinner()));
        });
    }

    @Override
    public Movie revert(MovieEntity obj) {
        return super.revert(obj, (to, from) -> {
            /*Studios*/
            Set<Studio> studios = to.getStudios().stream().map(s -> {
                final String name = s.getName().trim();
                return getInstance(name, Studio.class, () -> new Studio(name));
            }).collect(Collectors.toSet());
            from.setStudios(studios);

            /*Producers*/
            Set<Producer> producers = to.getProducers().stream().map(s -> {
                final String name = s.getName().trim();
                return getInstance(name, Producer.class, () -> new Producer(name));
            }).collect(Collectors.toSet());
            from.setProducers(producers);

            from.setWinner(obj.getWinner() ? Winner.YES : Winner.NO);
        });
    }

}
