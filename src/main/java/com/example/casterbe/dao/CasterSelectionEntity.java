package com.example.casterbe.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caster_selection")
@Data
@NoArgsConstructor
public class CasterSelectionEntity {
    @Id
    private String id;

    @OneToMany(mappedBy = "casterSelection", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CasterListEntity> casterList;
}
