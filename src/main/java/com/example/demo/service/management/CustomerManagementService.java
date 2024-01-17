package com.example.demo.service.management;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.api.request.CreateCustomerRequestDto;
import com.example.demo.dto.api.response.PutResponse;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.NoContentException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.AddressService;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CustomerManagementService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    public List<CustomerDto> getAllCustomers(){

        var customers = customerService.findAllUsers();
        if (customers.isEmpty()){
            throw new NoContentException("There are no customers");
        }
        return customers;
    }

    public CustomerDto createCustomer(CreateCustomerRequestDto request) {
        var customer = customerService.findByEmail(request.email());
        if(Objects.nonNull(customer)){
            throw new ConflictException("There already is a customer registered with that email");
        }
        var address = new AddressDto();
        address.setAddressName(request.address());
        address = addressService.saveAddress(address);
        customer = new CustomerDto();
        customer.setName(request.name());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setAddress(address);
        customer.setBooks(new ArrayList<>());
        return customerService.saveCustomer(customer);
    }

    public void deleteCustomerById(Long customerId) {

        var customer = customerService.findById(customerId);
        if (Objects.isNull(customer)){
            throw new NotFoundException("There is no customer with that id");
        }
        customerService.deleteCustomer(customer);
    }

    public void deleteCustomerByEmail(String customerEmail) {

        var customer = customerService.findByEmail(customerEmail);
        if (Objects.isNull(customer)){
            throw new NotFoundException("There is no customer with that email");
        }
        customerService.deleteCustomer(customer);
    }

    public PutResponse<CustomerDto> putCustomerById(Long customerId, CreateCustomerRequestDto request) {

        var customer = customerService.findById(customerId);

        if (Objects.isNull(customer)){
            customer = this.createCustomer(request);
            return new PutResponse.Created<CustomerDto>(customer);
        }
        var updatedCustomer = new CustomerDto();
        updatedCustomer.setName(request.name());
        updatedCustomer.setLastName(request.lastName());
        updatedCustomer.setEmail(request.email());
        updatedCustomer.setBooks(customer.getBooks());
        var oldAddress = customer.getAddress();
        updatedCustomer.setAddress(oldAddress);
        if (!Objects.equals(oldAddress.getAddressName(), request.address())){
            var newAddress = new AddressDto();
            newAddress.setAddressId(oldAddress.getAddressId());
            newAddress.setAddressName(request.address());
            updatedCustomer.setAddress(newAddress);
            int idk = addressService.updateAddress(newAddress);
            log.warn(Integer.toString(idk));
        }

        customerService.updateCustomer(updatedCustomer);
        return new PutResponse.Updated<>(customer);
    }

    public CustomerDto getCustomerById(Long id) {
        var customer = customerService.findById(id);
        if (Objects.isNull(customer)){
            throw new NotFoundException("There is no customer with that id");
        }
        return customer;
    }
}
