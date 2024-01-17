package com.example.demo.repository;

import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.BookEntity;
import com.example.demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update CustomerEntity c set c.name = ?1, c.lastName = ?2, c.email = ?3 where c.customerId = ?4")
    int updateNameAndLastNameAndEmailByCustomerId(String name, String lastName, String email, Long customerId);
}