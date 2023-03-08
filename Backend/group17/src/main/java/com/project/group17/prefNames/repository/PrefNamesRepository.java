package com.project.group17.prefNames.repository;

import com.project.group17.prefNames.entity.PrefNamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefNamesRepository extends JpaRepository<PrefNamesEntity, Long> {
}
