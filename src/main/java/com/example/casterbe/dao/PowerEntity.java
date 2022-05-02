package com.example.casterbe.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
