package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.dto.AnkietyDto;
import com.ankiety.ankiety.repository.AnkietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnkietyServiceImpl implements AnkietyService {

    private final AnkietyRepository ankietyRepository;

    public AnkietyServiceImpl(AnkietyRepository ankietyRepository) {
        this.ankietyRepository = ankietyRepository;
    }

    @Override
    public List<AnkietyDto> getAnkiety() {
       return ankietyRepository.findAll()
                .stream()
                .map(AnkietyDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAnkietaPytania(String nazwaAnkiety) {

        return ankietyRepository.findAllByNazwaAnkiety(nazwaAnkiety)
                .stream()
                .map(Ankiety::getPytanie)
                .collect(Collectors.toList());
    }
    @Override
    public List<AnkietyDto> getAnkietyPytaniaOdpowiedzi(String nazwaAnkiety) {
        return ankietyRepository.findAllByNazwaAnkiety(nazwaAnkiety)
                .stream()
                .map(AnkietyDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Ankiety addAnkiety(Ankiety ankiety) {
        return ankietyRepository.save(ankiety);
    }
}
