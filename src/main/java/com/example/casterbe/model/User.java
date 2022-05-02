package com.example.casterbe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String id;

    private String username;

    private String password;

    private boolean accountLocked;
}
