package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.TresciOdpowiedzi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdpowiedziOsobRepository extends JpaRepository<OdpowiedziOsob, Integer> {
    boolean existsOdpowiedziOsobsByAnkietyAndOsoby(Ankiety ankiety, Osoby osoby);
    int countOdpowiedziOsobByAnkietyAndTresciOdpowiedzi(Ankiety ankiety, TresciOdpowiedzi tresciOdpowiedzi);
}
