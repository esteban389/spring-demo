package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private AddressMapper mapper;


    public AddressDto saveAddress(AddressDto address) {
        var entity = mapper.toEntity(address);
        return mapper.toDto(
                    repository.save(entity
                ));
    }

    public void deleteAddress(AddressDto oldAddress) {

        repository.delete(mapper.toEntity(oldAddress));
    }

    public int updateAddress(AddressDto newAddress) {
        return repository.updateAddressNameByAddressId(
                newAddress.getAddressName(), newAddress.getAddressId()
        );
    }
}
