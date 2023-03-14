package com.project.group17.prefValues.repository;

import com.project.group17.prefValues.entity.PrefValuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrefValuesRepository extends JpaRepository<PrefValuesEntity, Long> {
    @Query("select pv from PrefValuesEntity pv where pv.user.id = :userId and pv.prefName.prefId = :prefNameId")
    Optional<PrefValuesEntity> findByUserAndPrefName(Integer userId, Long prefNameId);

    List<Optional<PrefValuesEntity>> getAllByUserId(Integer userId);
}
