package com.microservices.user.services;

import com.microservices.user.domain.User;
import com.microservices.user.entity.UserEntity;
import com.microservices.user.payloads.UserValidationResponse;
import com.microservices.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ValidateUser {
    private final UserRepository userRepository;

    public UserValidationResponse execute(User user) {
        UserEntity userEntity = userRepository.findByCpfAndPassword(user.getCpf(), user.getPassword());
        Boolean isUserValid = Objects.nonNull(userEntity);
        if (isUserValid) {
            return UserValidationResponse.builder().isValid(isUserValid).userId(userEntity.getId()).build();
        } else {
            return UserValidationResponse.builder().isValid(isUserValid).build();
        }
    }
}
