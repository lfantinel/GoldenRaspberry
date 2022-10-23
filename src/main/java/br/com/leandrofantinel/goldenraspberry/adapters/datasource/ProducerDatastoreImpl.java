package br.com.leandrofantinel.goldenraspberry.adapters.datasource;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.ProducerRepository;
import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.ProducerEntity;
import br.com.leandrofantinel.goldenraspberry.core.model.Producer;
import br.com.leandrofantinel.goldenraspberry.core.port.out.ProducerDataStore;
import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ProducerDatastoreImpl implements ProducerDataStore {

    private final ProducerRepository repository;
    private final MapperUtil<ProducerEntity, Producer> mapper;

    @Override
    public Set<Map<String, Object>> getProducerAwardsIntervals() {
        return repository.getProducerAwardsIntervals().stream()
                .filter(e->e.get("followingWin") != null).collect(Collectors.toSet());
    }
}
