package com.task.inventory.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Drink extends AbstractEntity {

    private String code;

    private String name;

    private double price;

    private int number;

}
