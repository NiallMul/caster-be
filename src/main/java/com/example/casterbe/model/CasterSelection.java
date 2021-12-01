package com.example.casterbe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CasterSelection {
    private List<CasterList> casterList;
}
