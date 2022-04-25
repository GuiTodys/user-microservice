package com.microservices.user.services;

import com.microservices.user.domain.User;
import com.microservices.user.entity.UserEntity;
import com.microservices.user.exceptions.UserAlreadyRegisteredException;
import com.microservices.user.mappers.UserEntityMapper;
import com.microservices.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;
    private UserEntityMapper userEntityMapper = UserEntityMapper.INSTANCE;

    public User execute(User user) {
        if (isUserRegistered(user)) {
            throw UserAlreadyRegisteredException.builder().build();
        }
        UserEntity userEntity = userEntityMapper.toEntity(user);
        return userEntityMapper.toDomain(userRepository.save(userEntity));
    }

    private Boolean isUserRegistered(User user) {
        return Objects.nonNull(userRepository.findByCpf(user.getCpf()));
    }
}
