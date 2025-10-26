package com.zoosoft.app.ZooSoft.service;

import com.zoosoft.app.ZooSoft.dto.AnimalDTO;
import com.zoosoft.app.ZooSoft.model.AnimalEntity;
import com.zoosoft.app.ZooSoft.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements IAnimalService{

    private final AnimalRepository animalRepository;


    @Override
    public List<AnimalDTO> getAllAnimals() {
        List<AnimalEntity> animalEntityList = animalRepository.findAll().stream().toList();
        List<AnimalDTO> animalDTOList = new ArrayList<>();
        for(AnimalEntity animalEntity1: animalEntityList){
            AnimalDTO animalDTO = new AnimalDTO();
            animalDTO.setAnimalKingdom(animalEntity1.getAnimalKingdom());
            animalDTO.setAnimalName(animalEntity1.getAnimalName());
            animalDTO.setId(animalEntity1.getId());
            animalDTOList.add(animalDTO);
        }
        return animalDTOList;
    }

    @Override
    public void addAnimal(AnimalDTO animalDTO) {
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setAnimalKingdom(animalDTO.getAnimalKingdom());
        animalEntity.setAnimalName(animalDTO.getAnimalName());
        animalRepository.save(animalEntity);
    }

    @Override
    public void updateAnimalByID(Long id, AnimalDTO animalDTO) {
        if(!animalRepository.existsById(id)){
            return;
        }else{
            AnimalEntity animalEntity = animalRepository.findById(id).orElseThrow();
            animalEntity.setAnimalName(animalDTO.getAnimalName());
            animalEntity.setAnimalName(animalDTO.getAnimalName());
            animalRepository.save(animalEntity);
            animalRepository.flush();
        }
    }


    @Override
    public void deleteAnimalByID(Long id){
        animalRepository.deleteById(id);
    }

}
