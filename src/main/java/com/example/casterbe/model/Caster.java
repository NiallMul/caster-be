package com.example.casterbe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Caster {
    private String id;
    private String name;
    private List<Power> powers;

}
