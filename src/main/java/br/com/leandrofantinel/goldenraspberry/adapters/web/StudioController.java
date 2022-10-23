package br.com.leandrofantinel.goldenraspberry.adapters.web;

import br.com.leandrofantinel.goldenraspberry.core.model.Studio;
import br.com.leandrofantinel.goldenraspberry.core.port.out.StudioDatasourcePort;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Studio")
@RestController
@RequestMapping("studio")
@RequiredArgsConstructor
class StudioController implements AbstractController<Studio> {

    private final StudioDatasourcePort datasource;

    @Override
    public StudioDatasourcePort getDatasource() {
        return datasource;
    }
}
