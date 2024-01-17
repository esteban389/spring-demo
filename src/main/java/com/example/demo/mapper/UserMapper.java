package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.CustomerEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    CustomerEntity toEntity(CustomerDto customerDto);

    CustomerDto toDto(CustomerEntity customerEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerEntity partialUpdate(CustomerDto customerDto, @MappingTarget CustomerEntity customerEntity);
}