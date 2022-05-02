package com.example.casterbe.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caster")
public class CasterEntity {
    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "casterid", cascade = CascadeType.ALL)
    private List<PowerEntity> powerList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caster_list", nullable = false)
    private CasterListEntity list_id;
}
