package br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa;

import br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}