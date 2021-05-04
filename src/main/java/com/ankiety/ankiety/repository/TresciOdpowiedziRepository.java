package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.TresciOdpowiedzi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TresciOdpowiedziRepository extends JpaRepository<TresciOdpowiedzi, Integer> {

    boolean existsByTrescOdpowiedzi(String trescOdpowiedzi);
    Optional<TresciOdpowiedzi> findByTrescOdpowiedzi(String trescOdpowiedzi);

}
