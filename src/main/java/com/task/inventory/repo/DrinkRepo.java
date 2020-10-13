package com.task.inventory.repo;

import com.task.inventory.domain.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends CrudRepository<Drink, Long> {

    Drink findByName(String name);

    Drink findByCode(String code);
}
