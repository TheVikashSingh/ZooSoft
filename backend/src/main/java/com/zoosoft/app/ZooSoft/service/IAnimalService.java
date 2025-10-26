package com.zoosoft.app.ZooSoft.service;

import com.zoosoft.app.ZooSoft.dto.AnimalDTO;
import com.zoosoft.app.ZooSoft.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAnimalService {

  List<AnimalDTO> getAllAnimals();

  void addAnimal(AnimalDTO animalDTO);

  void updateAnimalByID(Long id, AnimalDTO animalDTO);

  void deleteAnimalByID(Long id);

}
