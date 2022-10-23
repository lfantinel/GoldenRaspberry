package br.com.leandrofantinel.goldenraspberry.config.spring;

import br.com.leandrofantinel.goldenraspberry.core.port.in.LoadMoviesFile;
import br.com.leandrofantinel.goldenraspberry.core.port.out.MovieDatasourcePort;
import br.com.leandrofantinel.goldenraspberry.core.port.out.ProducerDatasourcePort;
import br.com.leandrofantinel.goldenraspberry.core.usecase.GetProducersAwardsIntervalUseCase;
import br.com.leandrofantinel.goldenraspberry.core.usecase.LoadMoviesFileUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UseCaseProvider {

    @Bean
    LoadMoviesFileUseCase getLoadMoviesFileUseCase(LoadMoviesFile csvDatastore, MovieDatasourcePort datastore){
        return new LoadMoviesFileUseCase(csvDatastore, datastore);
    }

    @Bean
    GetProducersAwardsIntervalUseCase getProducersAwardsIntervalUseCase(ProducerDatasourcePort datastore){
        return new GetProducersAwardsIntervalUseCase(datastore);
    }

}
