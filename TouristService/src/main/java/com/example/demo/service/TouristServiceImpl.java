
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tourist;
import com.example.demo.repository.TouristRepository;

@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    private TouristRepository repository;

    @Override
    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }

    @Override
    public Tourist addTourist(Tourist tourist) {
        return repository.save(tourist);
    }

    @Override
    public Tourist updateTourist(int id, Tourist tourist) {

        Tourist existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(tourist.getName());
        existing.setEmail(tourist.getEmail());
        existing.setCountry(tourist.getCountry());

        return repository.save(existing);
    }
}
