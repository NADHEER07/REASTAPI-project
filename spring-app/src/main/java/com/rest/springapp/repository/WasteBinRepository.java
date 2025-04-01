package com.rest.springapp.repository;

import com.rest.springapp.entities.WasteBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteBinRepository extends JpaRepository<WasteBin, Long> {
}
