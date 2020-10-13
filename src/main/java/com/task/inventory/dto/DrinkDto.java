package com.task.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrinkDto extends AbstractDto {

    private String code;

    private String name;

    private double price;

    private int number;

}
