package com.example.casterbe.dao.repositories;

import com.example.casterbe.dao.CasterSelectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CasterRepository extends JpaRepository<CasterSelectionEntity, String> {
    Optional<CasterSelectionEntity> findAllById(String id);
}
