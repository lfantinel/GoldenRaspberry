package br.com.leandrofantinel.goldenraspberry.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbstractModel {
    protected AbstractModel() { }

    private Integer id;
}
