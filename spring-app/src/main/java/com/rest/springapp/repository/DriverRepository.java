package com.rest.springapp.repository;

import com.rest.springapp.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    
    Page<Driver> findAll(Pageable pageable);

    // ✅ Search drivers by name with pagination & sorting
    @Query("SELECT d FROM Driver d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Driver> searchDriversByName(String keyword, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Driver d SET d.name = :name, d.licenseNumber = :licenseNumber WHERE d.id = :id")
    int updateDriver(Integer id, String name, String licenseNumber);

    // ✅ Delete driver by ID
    @Transactional
    @Modifying
    @Query("DELETE FROM Driver d WHERE d.id = :id")
    void deleteDriverById(Integer id);
}
