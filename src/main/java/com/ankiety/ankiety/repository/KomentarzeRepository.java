package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.Komentarze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomentarzeRepository extends JpaRepository<Komentarze, Integer> {

    Komentarze findByIdKomentarza(int id);
}
