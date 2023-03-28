package com.project.group17.group.repository;

import com.project.group17.group.entity.GroupEntity;
import com.project.group17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    List<GroupEntity> findByUserId(Long userID);


    @Query(value = "SELECT max(total_groups) FROM groups", nativeQuery = true)
    int getMaxGroupCount();

    @Query(value = "SELECT group_id FROM groups WHERE user = ?1", nativeQuery = true)
    int getGroupId(int user);


    @Query(value = "SELECT user FROM groups WHERE group_id = ?1", nativeQuery = true)
    List<Integer> getUsersByGroupId(int group_id);
}
