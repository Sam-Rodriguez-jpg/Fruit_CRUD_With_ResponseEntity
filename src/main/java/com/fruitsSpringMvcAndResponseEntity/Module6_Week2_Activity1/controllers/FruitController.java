package com.fruitsSpringMvcAndResponseEntity.Module6_Week2_Activity1.controllers;

import com.fruitsSpringMvcAndResponseEntity.Module6_Week2_Activity1.models.FruitModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.fruitsSpringMvcAndResponseEntity.Module6_Week2_Activity1.config.Database.fruitsList;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    // GET ALL
    @GetMapping
    public ResponseEntity<ArrayList<FruitModel>> getAllFruits() {
        if (fruitsList.isEmpty()) return new ResponseEntity<>(fruitsList, HttpStatus.valueOf(204));
        return new ResponseEntity<>(fruitsList, HttpStatus.valueOf(200));
    }


    // GET BY ID
    @GetMapping("/{inputIdFruit}")
    public ResponseEntity<FruitModel> getByIdFruit(@PathVariable String inputIdFruit) {
        for (FruitModel fruit : fruitsList) {
            if (fruit.getIdFruit().equals(inputIdFruit)) return new ResponseEntity<>(fruit, HttpStatus.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatus.valueOf(404));
    }


    // POST FOR ONE
    @PostMapping
    public ResponseEntity<FruitModel> postFruit(@RequestBody FruitModel inputFruit) {
        FruitModel newFruit = new FruitModel(
            inputFruit.getNameFruit(),
            inputFruit.getColorFruit(),
            inputFruit.getPriceFruit()
        );
        fruitsList.add(newFruit);
        return new ResponseEntity<>(newFruit, HttpStatus.valueOf(201));
    }


    // POST FOR MORE THAN ONE
    @PostMapping("/inputFruitList")
    public ResponseEntity<ArrayList<FruitModel>> postFruitList(@RequestBody ArrayList<FruitModel> inputFruitList) {
        for (FruitModel inputFruit : inputFruitList) {
            FruitModel newFruit = new FruitModel(
                    inputFruit.getNameFruit(),
                    inputFruit.getColorFruit(),
                    inputFruit.getPriceFruit()
            );
            fruitsList.add(newFruit);
        }
        return new ResponseEntity<>(fruitsList, HttpStatus.valueOf(201));
    }



    // PUT
    @PutMapping("/{inputIdFruit}")
    public ResponseEntity<FruitModel> putFruit(@PathVariable String inputIdFruit, @RequestBody FruitModel inputFruit) {
        for(FruitModel fruit : fruitsList) {
            if(fruit.getIdFruit().equals(inputIdFruit)) {
                fruit.setNameFruit(inputFruit.getNameFruit());
                fruit.setColorFruit(inputFruit.getColorFruit());
                fruit.setPriceFruit(inputFruit.getPriceFruit());
                return new ResponseEntity<>(fruit, HttpStatus.valueOf(200));
            }
        }
        return new ResponseEntity<>(HttpStatus.valueOf(404));
    }



    // PATCH
    @PatchMapping("/{inputIdFruit}")
    public ResponseEntity<FruitModel> patchFruit(@PathVariable String inputIdFruit, @RequestBody FruitModel inputFruit) {
        for(FruitModel fruit : fruitsList) {
            if(fruit.getIdFruit().equals(inputIdFruit)) {
                if(inputFruit.getNameFruit() != null && !inputFruit.getNameFruit().isEmpty()) {
                    fruit.setNameFruit(inputFruit.getNameFruit());
                }
                if(inputFruit.getColorFruit() != null && !inputFruit.getColorFruit().isEmpty()) {
                    fruit.setColorFruit(inputFruit.getColorFruit());
                }
                if(inputFruit.getPriceFruit() != null && !inputFruit.getPriceFruit().isEmpty()) {
                    fruit.setPriceFruit(inputFruit.getPriceFruit());
                }
                return new ResponseEntity<>(fruit, HttpStatus.valueOf(200));
            }
        }
        return new ResponseEntity<>(HttpStatus.valueOf(404));
    }



    // DELETE
    @DeleteMapping("/{inputIdFruit}")
    public ResponseEntity<FruitModel> deleteFruit(@PathVariable String inputIdFruit) {
        for(FruitModel fruit : fruitsList) {
            if(fruit.getIdFruit().equals(inputIdFruit)) {
                fruitsList.remove(fruit);
                return new ResponseEntity<>(HttpStatus.valueOf(204));
            }
        }
        return new ResponseEntity<>(HttpStatus.valueOf(404));
    }
}
