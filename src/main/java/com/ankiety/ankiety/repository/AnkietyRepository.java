package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.Ankiety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnkietyRepository extends JpaRepository<Ankiety, Integer> {

    List<Ankiety> findAllByNazwaAnkiety(String nazwaAnkiety);
    @Query("SELECT DISTINCT nazwaAnkiety FROM Ankiety")
    List<String> findDistinctByNazwaAnkiety();

    Ankiety findByIdPytania(int id);
    Ankiety findByNazwaAnkietyAndPytanie(String nazwaAnkiety, String pytanie);
}
