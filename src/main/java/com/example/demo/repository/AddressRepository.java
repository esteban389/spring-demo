package com.example.demo.repository;

import com.example.demo.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    @Transactional
    @Modifying
    @Query("update AddressEntity a set a.addressName = ?1 where a.addressId = ?2")
    int updateAddressNameByAddressId(String addressName, Long addressId);
}