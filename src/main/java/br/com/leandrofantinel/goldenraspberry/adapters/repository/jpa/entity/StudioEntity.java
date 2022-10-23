package br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDIO")
public class StudioEntity extends AbstractEntity {
    private String name;

}
