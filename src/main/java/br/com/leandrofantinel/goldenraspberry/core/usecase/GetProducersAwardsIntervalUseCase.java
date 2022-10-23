package br.com.leandrofantinel.goldenraspberry.core.usecase;

import br.com.leandrofantinel.goldenraspberry.core.port.out.ProducerDatasourcePort;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetProducersAwardsIntervalUseCase {
    private final ProducerDatasourcePort datastore;

    public Map<String, Object> execute() {
        Map<String, Object> data = new HashMap<>();
        Set<Map<String, Object>> list = datastore.getProducerAwardsIntervals();
        data.put("min", getFasterAwardInterval(list));
        data.put("max", getMaxAwardInterval(list));
        return data;
    }

    private Set<Map<String, Object>> getFasterAwardInterval(Set<Map<String, Object>> list) {
        int first = list.stream().mapToInt(e->(Integer)e.get("previousWin")).min().orElse(-1);
        int faster = list.stream().mapToInt(e->(Integer)e.get("followingWin") - first).min().orElse(-1);
        return list.stream().filter(e -> ((Integer)e.get("followingWin") - first) == faster).collect(Collectors.toSet());
    }

    private Set<Map<String, Object>> getMaxAwardInterval(Set<Map<String, Object>> list) {
        int longest = list.stream().mapToInt(e->(Integer)e.get("interval")).max().orElse(-1);
        return list.stream().filter(e -> ((Integer)e.get("interval")) == longest).collect(Collectors.toSet());
    }


}
