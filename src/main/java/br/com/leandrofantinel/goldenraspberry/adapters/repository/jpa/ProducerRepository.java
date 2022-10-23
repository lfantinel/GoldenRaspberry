package br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer> {

    @Query("SELECT new map(" +
            " p.name as producer, m.year as previousWin," +
            " (SELECT min(m2.year)" +
            "    FROM MovieEntity m2" +
            "    JOIN m2.producers p2" +
            "   WHERE p2.id = p.id" +
            "     AND m2.winner = true" +
            "     AND m2.year > m.year) as followingWin," +
            " coalesce((SELECT min(m2.year)" +
            "    FROM MovieEntity m2" +
            "    JOIN m2.producers p2" +
            "   WHERE p2.id = p.id" +
            "     AND m2.winner = true" +
            "     AND m2.year > m.year) - m.year, 0) as interval" +
            ")" +
            "  FROM ProducerEntity p " +
            "  JOIN p.movies m" +
            " WHERE m.winner = true" +
            " ORDER BY m.year")
    Set<Map<String, Object>> getProducerAwardsIntervals();
}