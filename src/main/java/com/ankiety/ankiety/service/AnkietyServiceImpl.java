package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.AnkietyDto;
import com.ankiety.ankiety.repository.AnkietyRepository;
import com.ankiety.ankiety.repository.TresciOdpowiedziRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        ankiety.getTresciOdpowiedzi().clear();

        ankietyDto.getTresciOdpowiedzi().forEach(trescOdpowiedzi -> {
                    Optional<TresciOdpowiedzi> tresciOdpowiedziOptional = tresciOdpowiedziRepository.findByTrescOdpowiedzi(trescOdpowiedzi.getTrescOdpowiedzi());
            if(tresciOdpowiedziOptional.isPresent()){
                TresciOdpowiedzi odpowiedz = tresciOdpowiedziOptional.get();
                System.out.println("Odpowiedz '" + odpowiedz + "' juz jest w bazie danych.");
                ankiety.getTresciOdpowiedzi().add(odpowiedz);
            }else{
                TresciOdpowiedzi nowaOdpowiedz = new TresciOdpowiedzi(trescOdpowiedzi.getTrescOdpowiedzi());
                ankiety.getTresciOdpowiedzi().add(nowaOdpowiedz);
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
