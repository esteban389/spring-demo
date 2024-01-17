package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    AddressEntity toEntity(AddressDto addressDto);

    AddressDto toDto(AddressEntity addressEntity);
}
