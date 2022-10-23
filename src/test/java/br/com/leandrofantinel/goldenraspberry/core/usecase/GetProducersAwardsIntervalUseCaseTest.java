package br.com.leandrofantinel.goldenraspberry.core.usecase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GetProducersAwardsIntervalUseCaseTest {

    @Autowired GetProducersAwardsIntervalUseCase useCase;

    @Test
    public void getProducersAwardsIntervalTest() {
        Map<String, Object> data = useCase.execute();

        assertTrue(data.containsKey("min"), "should have the attribute min");
        Set<Map<String, Object>> min = (Set<Map<String, Object>>) data.get("min");
        checkData(min);

        assertTrue(data.containsKey("max"), "should have the attribute max");
        Set<Map<String, Object>> max = (Set<Map<String, Object>>) data.get("max");
        checkData(max);

    }

    private void checkData(Set<Map<String, Object>> list){
        list.forEach(data -> {
            assertTrue(data.containsKey("producer"), "should have the attribute producer");
            assertTrue(data.get("producer") instanceof String, "should be String");

            assertTrue(data.containsKey("interval"), "should have the attribute interval");
            assertTrue(data.get("interval") instanceof Integer, "should be Integer");

            assertTrue(data.containsKey("previousWin"), "should have the attribute previousWin");
            assertTrue(data.get("previousWin") instanceof Integer, "should be Integer");

            assertTrue(data.containsKey("followingWin"), "should have the attribute followingWin");
            assertTrue(data.get("followingWin") instanceof Integer, "should be Integer");
        });
    }

}
