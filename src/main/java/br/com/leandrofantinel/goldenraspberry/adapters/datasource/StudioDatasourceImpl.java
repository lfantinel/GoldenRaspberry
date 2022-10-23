package br.com.leandrofantinel.goldenraspberry.adapters.datasource;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.StudioRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.ProducerEntity;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.StudioEntity;
import br.com.leandrofantinel.goldenraspberry.core.model.Producer;
import br.com.leandrofantinel.goldenraspberry.core.model.Studio;
import br.com.leandrofantinel.goldenraspberry.core.port.out.StudioDatasourcePort;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class StudioDatasourceImpl
        implements GenericDatasource<Studio, StudioEntity>, StudioDatasourcePort {

    private final StudioRepository repository;
    private final MapperUtil<Producer, ProducerEntity> mapper;

    @Override
    public StudioRepository getRepository() {
        return repository;
    }

    @Override
    public MapperUtil<Producer, ProducerEntity> getMapper() {
        return mapper;
    }
}
