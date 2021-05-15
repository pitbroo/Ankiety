package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.dto.FilterOdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.IloscOdpowiedziDto;

import java.util.List;

public interface OdpowiedziOsobService {
    List<OdpowiedziOsobDto> getOdpowiedziOsob();
    List<OdpowiedziOsob> addOdpowiedziOsob(List<OdpowiedziOsobDto> odpowiedziOsobDtoList);

    List<FilterOdpowiedziOsobDto> addOdpowiedziDoAnkiety(List<FilterOdpowiedziOsobDto> filterOdpowiedziOsobDto);
    List<IloscOdpowiedziDto> countOdpowiedziOsob(String nazwaAnkiety);

}
