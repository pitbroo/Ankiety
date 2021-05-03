package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.dto.PostFrontAnkiety;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;

import java.util.List;

public interface OdpowiedziOsobService {
    List<OdpowiedziOsobDto> getOdpowiedziOsob();
    List<OdpowiedziOsob> addOdpowiedziOsob(List<OdpowiedziOsobDto> odpowiedziOsobDtoList);

    void dodajBrodziaka(PostFrontAnkiety postFrontAnkiety);

}
