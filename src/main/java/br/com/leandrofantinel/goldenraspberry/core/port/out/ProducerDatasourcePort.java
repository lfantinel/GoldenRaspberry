package br.com.leandrofantinel.goldenraspberry.core.port.out;

import br.com.leandrofantinel.goldenraspberry.core.model.Producer;

import java.util.Map;
import java.util.Set;

public interface ProducerDatasourcePort extends GenericDatasourcePort<Producer> {
    Set<Map<String, Object>> getProducerAwardsIntervals();
}
