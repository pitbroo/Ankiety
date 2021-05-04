package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.dto.OsobyDto;

import java.util.List;

public interface OsobyService {
    List<OsobyDto> getOsoby();
    Osoby addOsoba(OsobyDto osoba);
}
