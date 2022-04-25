package com.microservices.user.mappers;

import com.microservices.user.domain.User;
import com.microservices.user.payloads.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {
    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    User toDomain(UserResponse userResponse);

    UserResponse toResponse(User user);
}
