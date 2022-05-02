package com.example.casterbe.service;

import com.example.casterbe.dao.repositories.CasterListRepository;
import com.example.casterbe.dao.repositories.CasterSelectionRepository;
import com.example.casterbe.mappers.CasterListMapper;
import com.example.casterbe.mappers.CasterMapper;
import com.example.casterbe.mappers.CasterSelectionMapper;
import com.example.casterbe.model.Caster;
import com.example.casterbe.model.CasterList;
import com.example.casterbe.model.CasterSelection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CasterSelectionServiceImpl implements CasterSelectionService {
    private final CasterSelectionRepository casterSelectionRepository;
    private final CasterListRepository casterListRepository;
    private final CasterSelectionMapper casterSelectionMapper;
    private final CasterListMapper casterListMapper;

    public CasterSelectionServiceImpl(CasterSelectionRepository casterSelectionRepository, CasterListRepository casterListRepository, CasterSelectionMapper casterSelectionMapper, CasterListMapper casterListMapper) {
        this.casterSelectionRepository = casterSelectionRepository;
        this.casterListRepository = casterListRepository;
        this.casterSelectionMapper = casterSelectionMapper;
        this.casterListMapper = casterListMapper;
    }

    @Override
    public CasterSelection getAllCasterSelections() {
        String dummyId = "c948b37f-9605-4848-886c-095ff3f7505b";
        return casterSelectionMapper.entityToModel(Optional.of(casterSelectionRepository.findById(dummyId)).get().get());
    }

    @Override
    public void updateCasterSelection(CasterList casterList) {
        casterListRepository.save(casterListMapper.modelToEntity(casterList));
    }

    @Override
    public CasterSelection removeCaster(Caster caster) {
        return null;
    }

}
