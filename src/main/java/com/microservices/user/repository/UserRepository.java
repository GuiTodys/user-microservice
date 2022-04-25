package com.microservices.user.repository;

import com.microservices.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByCpfAndPassword(String cpf, String password);

    UserEntity findByCpf(String cpf);
}
