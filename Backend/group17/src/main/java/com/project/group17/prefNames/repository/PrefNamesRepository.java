package com.project.group17.prefNames.repository;

import com.project.group17.prefNames.entity.prefNamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrefNamesRepository extends JpaRepository<prefNamesEntity, Long> {
}
