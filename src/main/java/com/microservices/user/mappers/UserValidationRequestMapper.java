package com.microservices.user.mappers;

import com.microservices.user.domain.User;
import com.microservices.user.payloads.UserValidationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserValidationRequestMapper {
    UserValidationRequestMapper INSTANCE = Mappers.getMapper(UserValidationRequestMapper.class);

    User toDomain(UserValidationRequest userValidationRequest);

    UserValidationRequest toRequest(User user);
}
