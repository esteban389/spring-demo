package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.api.request.CreateCustomerRequestDto;
import com.example.demo.dto.api.response.PutResponse;
import com.example.demo.service.management.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

/*
 * TODO add pagination to get All and search
 */

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerManagementService customerManagementService;

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {

        List<CustomerDto> customers = customerManagementService.getAllCustomers();
        return ResponseEntity
                .ok()
                .body(customers);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId){

        CustomerDto customer = customerManagementService.getCustomerById(customerId);
        return ResponseEntity
                .ok()
                .body(customer);
    }

    @GetMapping("search")
    public ResponseEntity<?> searchCustomer(@RequestParam(required = false,defaultValue = "10") Integer limit,
                                            @RequestParam(required = false,defaultValue = "0") Integer page,
                                            @RequestParam(required = false)Integer age){

        Pageable pageable = PageRequest.of(page,limit);
        //List<CustomerDto> customers = customerManagementService.searchCustomer(pageable);
        return ResponseEntity
                .ok()
                .body(pageable);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerRequestDto request) {

        CustomerDto customer = customerManagementService.createCustomer(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getCustomerId())
                .toUri();
        return ResponseEntity
                .created(location)
                .body(customer);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long customerId) {

        customerManagementService.deleteCustomerById(customerId);
        return ResponseEntity
                .ok()
                .build();
    }


    @PutMapping("{customerId}")
    public ResponseEntity<?> updateCustomerById(@PathVariable Long customerId, @RequestBody CreateCustomerRequestDto request) {

        PutResponse<CustomerDto> response = customerManagementService.putCustomerById(customerId, request);
        return switch (response) {
            case PutResponse.Updated<CustomerDto> update -> ResponseEntity.ok().body(update.data());
            case PutResponse.Created<CustomerDto> create -> {
                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(create.data().getCustomerId())
                        .toUri();
                yield ResponseEntity.created(location).body(create.data());
            }
        };
    }
}

