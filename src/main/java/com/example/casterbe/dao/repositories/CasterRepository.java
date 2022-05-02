package com.example.casterbe.dao.repositories;

import com.example.casterbe.dao.CasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CasterRepository extends JpaRepository<CasterEntity, String> {
    Optional<CasterEntity> findById(String id);
}
