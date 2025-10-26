package com.zoosoft.app.ZooSoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
    private Long Id;

    private String animalName;
    private String animalKingdom;
}
