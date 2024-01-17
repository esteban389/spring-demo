package com.example.demo.dto.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CreateCustomerRequestDto(

        @NotEmpty
        @NotNull
        String name,
        @NotNull
        @NotEmpty
        String lastName,
        @NotNull
        @NotEmpty
        String address,
        @NotNull
        @NotEmpty
        @Email
        String email
) {
}