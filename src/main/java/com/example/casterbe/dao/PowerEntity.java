package com.example.casterbe.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "power")
public class PowerEntity {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caster_id", nullable = false)
    private CasterEntity casterid;

}
