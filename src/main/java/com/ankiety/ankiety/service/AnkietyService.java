package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.dto.AnkietyDto;

import java.util.List;


public interface AnkietyService {
    List<AnkietyDto> getAnkiety();
    Ankiety addAnkiety(AnkietyDto ankiety);
    List<String> getAnkietaPytania(String nazwaAnkiety);
    List<AnkietyDto> getAnkietyByNazwa(String nazwaAnkiety);
    List<String> getAnkietyNazwa();
}
