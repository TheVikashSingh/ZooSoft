package com.zoosoft.app.ZooSoft.repository;

import com.zoosoft.app.ZooSoft.model.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}
