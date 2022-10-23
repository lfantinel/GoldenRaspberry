package br.com.leandrofantinel.goldenraspberry.adapters.web;

import br.com.leandrofantinel.goldenraspberry.core.usecase.GetProducersAwardsIntervalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("producer")
@RequiredArgsConstructor
class ProducerController {

    private final GetProducersAwardsIntervalUseCase useCase;

    @GetMapping(path = "awards-interval", produces = "application/json")
    public Map<String, Object> getAwardsInterval() {
        return useCase.execute();
    }

}
