package com.project.group17.group_match.repository;
import com.project.group17.group_match.entity.GroupMatchEntity;
import com.project.group17.user.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Scanner;

public interface GroupMatchRepository extends JpaRepository<GroupMatchEntity, Long> {
    void deleteById(long requestId);

    @Query(value = "SELECT user FROM group_matches WHERE group_id = ?1", nativeQuery = true)
    List<Integer> getUsersByGroupId(int group_id);

    @Query(value = "SELECT id FROM group_matches WHERE user = ?1", nativeQuery = true)
    long getIndexByUserId(long user_id);

}
