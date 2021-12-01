package com.example.casterbe.service;

import com.example.casterbe.dao.repositories.CasterRepository;
import com.example.casterbe.mappers.CasterSelectionMapper;
import com.example.casterbe.model.CasterSelection;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CasterSelectionServiceImpl implements CasterSelectionService {
    private final CasterRepository repository;
    private final CasterSelectionMapper mapper;
    private String dummyId = "c948b37f-9605-4848-886c-095ff3f7505b";

    public CasterSelectionServiceImpl(CasterRepository repository, CasterSelectionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CasterSelection getAllCasterSelections() {
        return mapper.entityToModel(Optional.of(repository.findById(dummyId)).get().get());
    }

}
