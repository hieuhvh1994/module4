package com.example.thithuchanhmodule4_hiieudao_backend.service.nation;

import com.example.thithuchanhmodule4_hiieudao_backend.model.Nation;
import com.example.thithuchanhmodule4_hiieudao_backend.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationService implements INationService {

    @Autowired
    INationRepository nationRepository;


    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return nationRepository.findById(id);
    }

    @Override
    public void save(Nation nation) {
        nationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);
    }
}
