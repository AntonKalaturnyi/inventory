package com.task.inventory.service;

import com.task.inventory.domain.Drink;
import com.task.inventory.dto.DrinkDto;
import com.task.inventory.mapper.DrinkMapper;
import com.task.inventory.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private final DrinkRepo drinkRepo;
    private final DrinkMapper mapper;

    @Autowired
    public InventoryService(DrinkRepo drinkRepo, DrinkMapper mapper) {
        this.drinkRepo = drinkRepo;
        this.mapper = mapper;
    }

    public List<DrinkDto> getAllDrinks() {
        return (ArrayList) ((ArrayList) drinkRepo.findAll()).stream().map(drink -> mapper.toDto((Drink) drink)).collect(Collectors.toList());
    }

    public Integer getDrinksAvailableByCode(String code) {
        return drinkRepo.findByCode(code).getNumber();
    }

    public Integer getDrinksAvailableByName(String name) {
        return drinkRepo.findByName(name).getNumber();
    }

    @Transactional
    public DrinkDto addDrinks(DrinkDto dto) {
        return mapper.toDto(drinkRepo.save(mapper.toEntity(dto)));
    }

    @Transactional
    public boolean deleteDrinksByCode(String code) {
        drinkRepo.deleteById(drinkRepo.findByCode(code).getId());
        return true;
    }

    @Transactional
    public DrinkDto takeOutDrink(String code) {
        Drink chosen = drinkRepo.findByCode(code);
        chosen.setNumber(chosen.getNumber() - 1);
        return mapper.toDto(drinkRepo.save(chosen));
    }
}
