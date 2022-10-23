package br.com.leandrofantinel.goldenraspberry.adapters.repository.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOVIE")
public class MovieEntity extends AbstractEntity{
    @Column(name = "AWARD_YEAR")
    private Integer year;
    private String title;
    private Boolean winner;

    @JsonIgnore
    @ManyToMany(cascade = {PERSIST,MERGE})
    @JoinTable(name = "movie_studio",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "studio_id") })
    private Set<StudioEntity> studios;

    @JsonIgnore
    @ManyToMany(cascade = {PERSIST,MERGE})
    @JoinTable(name = "movie_producer",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "producer_id") })
    private Set<ProducerEntity> producers;
}
