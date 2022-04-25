package com.microservices.user.services;

import com.microservices.user.domain.User;
import com.microservices.user.entity.UserEntity;
import com.microservices.user.exceptions.UserNotFoundException;
import com.microservices.user.mappers.UserEntityMapper;
import com.microservices.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUser {

    private final UserRepository userRepository;
    private UserEntityMapper userEntityMapper = UserEntityMapper.INSTANCE;

    public User byId(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> UserNotFoundException.builder().build());
        return userEntityMapper.toDomain(userEntity);
    }

    public List<User> getAll() {
        List<UserEntity> usersEntities = userRepository.findAll();
        return usersEntities.stream().map(user -> userEntityMapper.toDomain(user)).collect(Collectors.toList());
    }
}
