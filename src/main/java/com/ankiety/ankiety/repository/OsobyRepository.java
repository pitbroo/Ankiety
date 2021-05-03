package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.Osoby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OsobyRepository extends JpaRepository<Osoby, Integer> {

    Osoby findByIdOsoby(int id);
    Optional<Osoby> findByIPv4(String ipv4);

}
