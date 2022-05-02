package com.example.casterbe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CasterList {
    private String id;
    private String name;
    private List<Caster> casters;
}
