package com.microservices.user.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserValidationResponse {
    private Boolean isValid;
    private Long userId;
}
