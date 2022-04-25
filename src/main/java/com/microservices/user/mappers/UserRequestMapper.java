package com.microservices.user.mappers;

import com.microservices.user.domain.User;
import com.microservices.user.payloads.UserRequest;
import com.microservices.user.payloads.UserValidationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper {
    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    User toDomain(UserRequest userRequest);

    UserRequest toRequest(User user);
}
