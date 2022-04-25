package com.microservices.user.mappers;

import com.microservices.user.domain.User;
import com.microservices.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);
}
