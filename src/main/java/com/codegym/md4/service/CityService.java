package com.codegym.md4.service;

import com.codegym.md4.model.City;
import com.codegym.md4.repo.ICityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CityService implements ICityService {
private final ICityRepository cityRepository;
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findByName(String name) {
        return cityRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteById(Long id)  {
       cityRepository.deleteById(id);
    }

    @Override
    public City getDetailCityBy(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No city not found."));
    }
}
