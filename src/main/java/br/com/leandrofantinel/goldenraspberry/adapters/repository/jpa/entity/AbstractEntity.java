package br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@AllArgsConstructor
@MappedSuperclass
public class AbstractEntity {
    protected AbstractEntity() {}

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
}
