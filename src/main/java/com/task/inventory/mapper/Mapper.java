package com.task.inventory.mapper;

import com.task.inventory.domain.AbstractEntity;
import com.task.inventory.dto.AbstractDto;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
