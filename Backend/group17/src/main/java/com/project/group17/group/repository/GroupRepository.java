package com.project.group17.group.repository;

import com.project.group17.group.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    List<GroupEntity> findByUserId(Long userID);

    @Query(value = "SELECT max(total_groups) FROM groups", nativeQuery = true)
    int getMaxGroupCount();
}
