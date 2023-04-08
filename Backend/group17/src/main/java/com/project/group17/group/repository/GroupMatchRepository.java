package com.project.group17.group.repository;
import com.project.group17.group.entity.GroupMatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupMatchRepository extends JpaRepository<GroupMatchEntity, Long> {
    void deleteById(long requestId);

    @Query(value = "SELECT user FROM group_matches WHERE group_id = ?1", nativeQuery = true)
    List<Integer> getUsersByGroupId(int group_id);

    @Query(value = "SELECT id FROM group_matches WHERE user = ?1", nativeQuery = true)
    long getIndexByUserId(long user_id);

}
