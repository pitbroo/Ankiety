package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.repository.OsobyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsobyServiceImpl implements OsobyService {

    private final OsobyRepository osobyRepository;

    public OsobyServiceImpl(OsobyRepository osobyRepository) {
        this.osobyRepository = osobyRepository;
    }

    @Override
    public List<Osoby> getOsoby() {
        return osobyRepository.findAll();
    }

    @Override
    public Osoby addOsoba(Osoby osoba) {
        return osobyRepository.save(osoba);
    }
}
