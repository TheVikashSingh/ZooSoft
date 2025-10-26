package com.zoosoft.app.ZooSoft.controller;

import com.zoosoft.app.ZooSoft.dto.AnimalDTO;
import com.zoosoft.app.ZooSoft.service.AnimalServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class Controller {

    private final AnimalServiceImpl animalService;

    @GetMapping
    public List<AnimalDTO> getAnimals(){
        return animalService.getAllAnimals();
    }

    @PostMapping
    public void addAnimal(@RequestBody AnimalDTO animalDTO){
        animalService.addAnimal(animalDTO);
    }

    @PutMapping("/{id}")
    public void updateAnimalByID(@RequestBody AnimalDTO animalDTO, @PathVariable Long id){
        animalService.updateAnimalByID(id,animalDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimalByID(id);
    }
}
