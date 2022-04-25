package com.microservices.user.controllers;

import com.microservices.user.domain.User;
import com.microservices.user.mappers.UserRequestMapper;
import com.microservices.user.mappers.UserResponseMapper;
import com.microservices.user.mappers.UserValidationRequestMapper;
import com.microservices.user.payloads.UserRequest;
import com.microservices.user.payloads.UserResponse;
import com.microservices.user.payloads.UserValidationRequest;
import com.microservices.user.payloads.UserValidationResponse;
import com.microservices.user.services.CreateUser;
import com.microservices.user.services.GetUser;
import com.microservices.user.services.ValidateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUser createUser;
    private final GetUser getUser;
    private final ValidateUser validateUser;
    private UserResponseMapper userResponseMapper = UserResponseMapper.INSTANCE;
    private UserRequestMapper userRequestMapper = UserRequestMapper.INSTANCE;
    private UserValidationRequestMapper userValidationRequestMapper = UserValidationRequestMapper.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(
            @RequestBody UserRequest userRequest) {
        User user = userRequestMapper.toDomain(userRequest);
        return userResponseMapper.toResponse(createUser.execute(user));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(
            @PathVariable Long id
    ) {
        return userResponseMapper.toResponse(getUser.byId(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return getUser.getAll().stream().map(user -> userResponseMapper.toResponse(user)).collect(Collectors.toList());
    }

    @PostMapping("/validation")
    @ResponseStatus(HttpStatus.OK)
    public UserValidationResponse validateUserInformation(
            @RequestBody UserValidationRequest userValidationRequest) {
        User user = userValidationRequestMapper.toDomain(userValidationRequest);
        return validateUser.execute(user);
    }
}
