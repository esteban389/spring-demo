package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "age",nullable = false)
    private Integer age;
    @OneToOne
    @JoinColumn(name = "address", nullable = false)
    private AddressEntity address;
    @OneToMany
    @JoinColumn(name = "books", nullable = false)
    private List<BookEntity> books;
}
