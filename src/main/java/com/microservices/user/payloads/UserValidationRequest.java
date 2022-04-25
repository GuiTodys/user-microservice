package com.microservices.user.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserValidationRequest {
    @NotNull
    private String cpf;
    @NotNull
    @Size(min = 6, max = 6)
    private String password;
}
