package br.com.leandrofantinel.goldenraspberry.core.model.domain;

import br.com.leandrofantinel.goldenraspberry.util.json.enumerator.IEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Winner implements IEnum<Integer> {
    NO(0), YES(1);

    final Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String value() {
        return name().toLowerCase();
    }
}
