package com.project.group17.prefValues.Repository;

import com.project.group17.prefValues.entity.PrefValuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefValuesRepository extends JpaRepository<PrefValuesEntity, Long> {
}
