package com.rest.springapp.Service;

import com.rest.springapp.entities.Driver;
import com.rest.springapp.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(int id) {
        return driverRepository.findById(id);
    }

    public Driver updateDriver(int id, Driver newDriver) {
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setName(newDriver.getName());
                    driver.setLicenseNumber(newDriver.getLicenseNumber());
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not found with id " + id));
    }

    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }

    // ✅ Get drivers with pagination & sorting
    public Page<Driver> getDriversWithPagination(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }

    // ✅ Search drivers by name with pagination & sorting
    public Page<Driver> searchDrivers(String keyword, Pageable pageable) {
        return driverRepository.searchDriversByName(keyword, pageable);
    }
}
