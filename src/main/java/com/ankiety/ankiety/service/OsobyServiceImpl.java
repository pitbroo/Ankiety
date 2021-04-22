package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.dto.OsobyDto;
import com.ankiety.ankiety.repository.OsobyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OsobyServiceImpl implements OsobyService {

    private final OsobyRepository osobyRepository;

    public OsobyServiceImpl(OsobyRepository osobyRepository) {
        this.osobyRepository = osobyRepository;
    }

    @Override
    public List<OsobyDto> getOsoby() {
        return osobyRepository.findAll()
                .stream()
                .map(OsobyDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Osoby addOsoba(Osoby osoba) {
        return osobyRepository.save(osoba);
    }
}
