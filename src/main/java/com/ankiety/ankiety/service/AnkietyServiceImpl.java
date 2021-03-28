package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.repository.AnkietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnkietyServiceImpl implements AnkietyService {

    private final AnkietyRepository ankietyRepository;

    public AnkietyServiceImpl(AnkietyRepository ankietyRepository) {
        this.ankietyRepository = ankietyRepository;
    }

    @Override
    public List<Ankiety> getAnkiety() {
        return ankietyRepository.findAll();
    }

    @Override
    public Ankiety addAnkiety(Ankiety ankiety) {
        return ankietyRepository.save(ankiety);
    }
}
