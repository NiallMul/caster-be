package com.example.casterbe.controllers;

import com.example.casterbe.model.CasterSelection;
import com.example.casterbe.service.CasterSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
