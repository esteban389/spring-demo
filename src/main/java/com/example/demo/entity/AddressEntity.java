package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "address")
public class AddressEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "address_id", nullable = false)
        private Long addressId;
        @Column(name = "address_name",nullable = false)
        private String addressName;
}
