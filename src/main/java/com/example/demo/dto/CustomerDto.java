package com.example.demo.dto;

import com.example.demo.entity.CustomerEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link CustomerEntity}
 */
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerDto implements Serializable {
    private Long CustomerId;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    private AddressDto address;
    private List<BookDto> books;
}