package com.example.casterbe.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "login_attempts")
public class LoginAttemptsEntitiy {
    @Id
    private String id;

    private String username;

    private int attempts;
}
