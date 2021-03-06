package com.example.casterbe.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caster_list")
public class CasterListEntity {
    @Id
    private String id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caster_selection", nullable = false)
    private CasterSelectionEntity casterSelection;

    @OneToMany(mappedBy = "list_id", cascade = CascadeType.ALL)
    private List<CasterEntity> casters;
}
