package com.project.group17.match.repository;

import com.project.group17.match.entity.MatchEntity;
import com.project.group17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    List<MatchEntity> findByUser1(User user2ID);
    List<MatchEntity> findByUser2(User user1);
}
