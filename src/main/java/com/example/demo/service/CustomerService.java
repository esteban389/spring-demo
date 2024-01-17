package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private BookMapper bookMapper;
    public List<CustomerDto> findAllUsers() {

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public CustomerDto findByEmail(String email) {

        return repository.findByEmail(email)
                .map(mapper::toDto)
                .orElse(null);
    }

    public CustomerDto saveCustomer(CustomerDto customer) {
        var entity = mapper.toEntity(customer);
        return mapper.toDto(
                repository.save(entity)
        );
    }

    public CustomerDto findById(Long customerId) {

        return repository.findById(customerId)
                .map(mapper::toDto)
                .orElse(null);
    }

    public void deleteCustomer(CustomerDto customerDto) {

        repository.delete(mapper.toEntity(customerDto));
    }

    public int updateCustomer(CustomerDto updatedCustomer) {

        return repository.updateNameAndLastNameAndEmailByCustomerId(
                updatedCustomer.getName(),
                updatedCustomer.getLastName(),
                updatedCustomer.getEmail(),
                updatedCustomer.getCustomerId()
        );
    }
}
