package com.example.casterbe.dao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login_attempts")
public class LoginAttemptsEntitiy {
    @Id
    private String id;

    private String username;

    private int attempts;
}
