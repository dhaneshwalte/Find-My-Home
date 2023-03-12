package com.project.group17.user.repository;

import com.project.group17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Optional<UsersEntity> findByUserName(String userName);
    Optional<User> findByEmail(String email);
     Optional<User> findById(Integer id);
}
