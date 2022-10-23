package br.com.leandrofantinel.goldenraspberry.core.model;

import br.com.leandrofantinel.goldenraspberry.core.model.domain.Winner;
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
    private Set<Studio> studios;
    private Set<Producer> producers;
    private Winner winner;
}
