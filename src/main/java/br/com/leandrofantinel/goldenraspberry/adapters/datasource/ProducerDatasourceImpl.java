package br.com.leandrofantinel.goldenraspberry.adapters.datasource;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.ProducerRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.ProducerEntity;
import br.com.leandrofantinel.goldenraspberry.core.model.Producer;
import br.com.leandrofantinel.goldenraspberry.core.port.out.ProducerDatasourcePort;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ProducerDatasourceImpl
        implements ProducerDatasourcePort, GenericDatasource<Producer, ProducerEntity> {

    private final ProducerRepository repository;
    private final MapperUtil<Producer, ProducerEntity> mapper;

    @Override
    public Set<Map<String, Object>> getProducerAwardsIntervals() {
        return repository.getProducerAwardsIntervals().stream()
                .filter(e->e.get("followingWin") != null).collect(Collectors.toSet());
    }

    @Override
    public ProducerRepository getRepository() {
        return repository;
    }

    @Override
    public MapperUtil<Producer, ProducerEntity> getMapper() {
        return mapper;
    }
}
