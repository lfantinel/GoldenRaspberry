package br.com.leandrofantinel.goldenraspberry.adapters.web;

import br.com.leandrofantinel.goldenraspberry.core.model.Producer;
import br.com.leandrofantinel.goldenraspberry.core.port.out.ProducerDatasourcePort;
import br.com.leandrofantinel.goldenraspberry.core.usecase.GetProducersAwardsIntervalUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(tags = "Producer")
@RestController
@RequestMapping("producer")
@RequiredArgsConstructor
class ProducerController implements AbstractController<Producer> {

    private final GetProducersAwardsIntervalUseCase useCase;

    private final ProducerDatasourcePort datasource;

    @ApiOperation("List producers with longest interval between two consecutive awards (max)" +
            " and producers who got two awards faster (min).")
    @GetMapping(path = "awards-interval", produces = "application/json")
    public Map<String, Object> getAwardsInterval() {
        return useCase.execute();
    }

    @Override
    public ProducerDatasourcePort getDatasource() {
        return datasource;
    }
}
