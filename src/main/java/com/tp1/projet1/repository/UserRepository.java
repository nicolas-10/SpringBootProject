package com.tp1.projet1.repository;

import com.tp1.projet1.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
}
