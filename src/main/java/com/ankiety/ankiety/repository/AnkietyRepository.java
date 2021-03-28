package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.Ankiety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnkietyRepository extends JpaRepository<Ankiety, Integer> {
}
