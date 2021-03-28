package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.Osoby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobyRepository extends JpaRepository<Osoby, Integer> {
}
