package com.codegym.md4.service;

import com.codegym.md4.model.National;
import com.codegym.md4.repo.INationalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class NationalService implements INationalService {
    INationalRepository nationalRepository;
    @Override
    public List<National> getAllNational() {
        return nationalRepository.findAll();
    }
}
