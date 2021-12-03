package com.example.casterbe.dao.repositories;

import com.example.casterbe.dao.LoginAttemptsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptsRepository extends JpaRepository<LoginAttemptsEntitiy, String> {
    Optional<LoginAttemptsEntitiy> findByUsername(String username);
}
