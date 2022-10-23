package br.com.leandrofantinel.goldenraspberry.config;

import br.com.leandrofantinel.goldenraspberry.core.usecase.LoadMoviesFileUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class StartupApplicationListener
        implements ApplicationListener<ContextRefreshedEvent> {

    private final LoadMoviesFileUseCase useCase;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        useCase.execute("movielist.csv");
    }

}