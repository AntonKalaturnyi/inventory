package com.task.inventory.controller;

import com.task.inventory.dto.DrinkDto;
import com.task.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("drinks")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping(value = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DrinkDto> getAllDrinks() {
        return inventoryService.getAllDrinks();
    }

    @GetMapping(value = "/get-available-by-code")
    public Integer getAvailableDrinksByCode(String code) {
        return inventoryService.getDrinksAvailableByCode(code);
    }

    @GetMapping(value = "/get-available-by-name")
    public Integer getAvailableDrinksByName(String name) {
        return inventoryService.getDrinksAvailableByName(name);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete-item")
    public boolean deleteDrinks(String code) {
        return inventoryService.deleteDrinksByCode(code);
    }

    @PostMapping(value = "add-item", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public DrinkDto addDrink(@RequestBody DrinkDto dto) {
        return inventoryService.addDrinks(dto);
    }

    @PutMapping("take-out-one")
    public DrinkDto takeOutDrink(String code) {
        return inventoryService.takeOutDrink(code);
    }
}

/** Data for test
{
    "code": "A1",
    "name": "Coca-Cola Classic",
    "price": 2.5,
    "number": 12
  },
  {

    "code": "A2",
    "name": "Coca-Cola Light",
    "price": 2.3,
    "number": 14
  },
  {
    "code": "A3",
    "name": "Fanta Orange",
    "price": 2,
    "number": 11
  }
        */

