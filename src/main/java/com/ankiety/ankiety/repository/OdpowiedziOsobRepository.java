package com.ankiety.ankiety.repository;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdpowiedziOsobRepository extends JpaRepository<OdpowiedziOsob, Integer> {
}
