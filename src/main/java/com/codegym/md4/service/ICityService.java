package com.codegym.md4.service;

import com.codegym.md4.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    List<City> findByName(String name);
    void save(City city);
    void deleteById(Long id);
    City getDetailCityBy(Long id);;

}
