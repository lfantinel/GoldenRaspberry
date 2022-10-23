package br.com.leandrofantinel.goldenraspberry.core.model;

import br.com.leandrofantinel.goldenraspberry.core.model.domain.Winner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends AbstractModel{
    private Integer year;
    private String title;
    @JsonIgnore
    private Set<Studio> studios;
    @JsonIgnore
    private Set<Producer> producers;
    private Winner winner;
}
