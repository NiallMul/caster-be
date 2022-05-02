package com.example.casterbe.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caster_selection")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CasterSelectionEntity {
    @Id
    private String id;

    @OneToMany(mappedBy = "casterSelection", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CasterListEntity> casterList;
}
