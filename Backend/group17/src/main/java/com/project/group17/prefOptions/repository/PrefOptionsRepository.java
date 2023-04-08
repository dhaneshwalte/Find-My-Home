package com.project.group17.prefOptions.repository;

import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefOptionsRepository extends JpaRepository<PrefOptionsEntity, Integer> {
}