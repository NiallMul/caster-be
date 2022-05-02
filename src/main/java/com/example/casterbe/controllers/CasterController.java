package com.example.casterbe.controllers;

import com.example.casterbe.model.Caster;
import com.example.casterbe.model.CasterList;
import com.example.casterbe.model.CasterSelection;
import com.example.casterbe.service.CasterSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "casters")
public class CasterController {
    private final CasterSelectionService service;

    public CasterController(CasterSelectionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<CasterSelection> getCasters() {
        return ResponseEntity.ok(service.getAllCasterSelections());
    }

    @PostMapping
    public ResponseEntity<String> addCaster(@RequestBody CasterList casterList) {
        try {
            service.updateCasterSelection(casterList);
            return ResponseEntity.ok("Caster added to selection");
        } catch (Exception e) {
            return ResponseEntity.ok("Save failed please check logs: exception: " + e);
        }
    }

    @DeleteMapping
    public ResponseEntity<CasterSelection> removeCaster(Caster caster) {
        return ResponseEntity.ok(service.removeCaster(caster));
    }
}
