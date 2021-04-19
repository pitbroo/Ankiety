package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.AnkietyDto;
import com.ankiety.ankiety.repository.AnkietyRepository;
import com.ankiety.ankiety.repository.TresciOdpowiedziRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnkietyServiceImpl implements AnkietyService {

    private final AnkietyRepository ankietyRepository;
    private final TresciOdpowiedziRepository tresciOdpowiedziRepository;

    public AnkietyServiceImpl(AnkietyRepository ankietyRepository, TresciOdpowiedziRepository tresciOdpowiedziRepository) {
        this.ankietyRepository = ankietyRepository;
        this.tresciOdpowiedziRepository = tresciOdpowiedziRepository;
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
    public Ankiety addAnkiety(AnkietyDto ankietyDto) {
        Ankiety ankiety = new Ankiety(ankietyDto);
        List<TresciOdpowiedzi> tresciOdpowiedzi = ankiety.getTresciOdpowiedzi();
        tresciOdpowiedzi.forEach(trescOdpowiedzi -> {
            if(tresciOdpowiedziRepository.existsByTrescOdpowiedzi(trescOdpowiedzi.getTrescOdpowiedzi())) {
                System.out.println("Odpowiedz '" + trescOdpowiedzi.getTrescOdpowiedzi() + "' juz jest w bazie danych.");
                System.out.println(tresciOdpowiedziRepository.findByTrescOdpowiedzi(trescOdpowiedzi.getTrescOdpowiedzi()).getIdTresciOdpowiedzi());
                throw new IllegalStateException("Odpowiedz '" + trescOdpowiedzi.getTrescOdpowiedzi() + "' juz jest w bazie danych.");
            }
        }
        );

        return ankietyRepository.save(ankiety);
    }

    @Override
    public List<String> getAnkietyNazwa() {
        return ankietyRepository.findDistinctByNazwaAnkiety();
    }
}
