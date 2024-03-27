package com.codegym.md4.repo;

import com.codegym.md4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICityRepository extends JpaRepository<City, Long> {
    List<City> findAllByNameContainingIgnoreCase(String name);
}
