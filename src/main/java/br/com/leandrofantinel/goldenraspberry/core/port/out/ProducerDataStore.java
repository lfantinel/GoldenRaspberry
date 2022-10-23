package br.com.leandrofantinel.goldenraspberry.core.port.out;

import java.util.Map;
import java.util.Set;

public interface ProducerDataStore {
    Set<Map<String, Object>> getProducerAwardsIntervals();
}
