package com.example.casterbe.service;

import com.example.casterbe.model.Caster;
import com.example.casterbe.model.CasterList;
import com.example.casterbe.model.CasterSelection;

public interface CasterSelectionService {
    CasterSelection getAllCasterSelections();

    void updateCasterSelection(CasterList casterList);

    CasterSelection removeCaster(Caster caster);
}
