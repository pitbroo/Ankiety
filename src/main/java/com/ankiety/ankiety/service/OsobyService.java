package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Osoby;

import java.util.List;

public interface OsobyService {
    List<Osoby> getOsoby();
    Osoby addOsoba(Osoby osoba);
}
