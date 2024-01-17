package com.example.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.entity.BookEntity}
 */
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDto implements Serializable {
    private Long bookId;
    private String name;
    private String ISBN;
    private String image;
}