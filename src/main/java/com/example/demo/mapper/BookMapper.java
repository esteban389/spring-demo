package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    BookEntity toEntity(BookDto bookDto);

    BookDto toDto(BookEntity bookEntity);
}
