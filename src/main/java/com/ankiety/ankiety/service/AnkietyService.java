package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnkietyService {
    List<Ankiety> getAnkiety();
    Ankiety addAnkiety(Ankiety ankiety);

}
