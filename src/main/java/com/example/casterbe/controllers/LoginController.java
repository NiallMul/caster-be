package com.example.casterbe.controllers;

import com.example.casterbe.model.User;
import com.example.casterbe.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "user")
@Api(tags = "User controller", consumes = "application/json")
public class LoginController {
    private final UserService service;

    public LoginController(UserService service) {
        this.service = service;
    }

    @PostMapping(path = "login")
    @ApiOperation(value = "Login user", notes = "logs a user into the system")
    public ResponseEntity<User> login(@RequestBody User user){
        return ResponseEntity.ok(service.login(user));
    }
}
