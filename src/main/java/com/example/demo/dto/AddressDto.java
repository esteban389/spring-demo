package com.example.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.entity.AddressEntity}
 */
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressDto implements Serializable {
    private Long addressId;
    private String addressName;
}