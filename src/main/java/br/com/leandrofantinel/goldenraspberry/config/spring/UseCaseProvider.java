package br.com.leandrofantinel.goldenraspberry.config.spring;

import br.com.leandrofantinel.goldenraspberry.core.port.in.LoadMoviesFile;
import br.com.leandrofantinel.goldenraspberry.core.port.out.MovieDataStore;
import br.com.leandrofantinel.goldenraspberry.core.port.out.ProducerDataStore;
import br.com.leandrofantinel.goldenraspberry.core.usecase.GetProducersAwardsIntervalUseCase;
import br.com.leandrofantinel.goldenraspberry.core.usecase.LoadMoviesFileUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UseCaseProvider {

    @Bean
    LoadMoviesFileUseCase getLoadMoviesFileUseCase(LoadMoviesFile csvDatastore, MovieDataStore datastore){
        return new LoadMoviesFileUseCase(csvDatastore, datastore);
    }

    @Bean
    GetProducersAwardsIntervalUseCase getProducersAwardsIntervalUseCase(ProducerDataStore datastore){
        return new GetProducersAwardsIntervalUseCase(datastore);
    }

}
