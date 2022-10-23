package br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCER")
public class ProducerEntity extends AbstractEntity {

    private String name;

    public ProducerEntity(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy="producers")
    private Set<MovieEntity> movies;
}
