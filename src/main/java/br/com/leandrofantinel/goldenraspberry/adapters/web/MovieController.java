package br.com.leandrofantinel.goldenraspberry.adapters.web;

import br.com.leandrofantinel.goldenraspberry.core.model.Movie;
import br.com.leandrofantinel.goldenraspberry.core.port.out.MovieDatasourcePort;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Movie")
@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
class MovieController implements AbstractController<Movie> {

    private final MovieDatasourcePort datasource;

    @Override
    public MovieDatasourcePort getDatasource() {
        return datasource;
    }
}
