package com.example.casterbe.service;

import com.example.casterbe.dao.UserEntity;
import com.example.casterbe.dao.repositories.UserRepository;
import com.example.casterbe.mappers.UserMapper;
import com.example.casterbe.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public User login(User user) {
        Optional<UserEntity> registerUser = repo.findUserEntitiesByUsername(user.getUsername());
        if (registerUser.isPresent()) {
            return mapper.entityToModel(registerUser.get());
        } else {
            log.error("User not found, username: " + user.getUsername());
            throw new ResourceNotFoundException();
        }
    }
}
