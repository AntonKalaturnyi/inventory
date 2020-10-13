package com.task.inventory.mapper;

import com.task.inventory.domain.Drink;
import com.task.inventory.dto.DrinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrinkMapper extends AbstractMapper<Drink, DrinkDto> {

    @Autowired
    public DrinkMapper() {
        super(Drink.class, DrinkDto.class);
    }
}
