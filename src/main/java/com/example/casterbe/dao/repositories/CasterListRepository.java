package com.example.casterbe.dao.repositories;

import com.example.casterbe.dao.CasterListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CasterListRepository extends JpaRepository<CasterListEntity, String> {
    Optional<CasterListEntity> findById(String id);
}
