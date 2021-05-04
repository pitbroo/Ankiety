package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.TresciOdpowiedziDto;

import java.util.List;

public interface TresciOdpowiedziService {
    List<TresciOdpowiedziDto> getTresciOdpowiedzi();

    TresciOdpowiedzi addTrescOdpowiedzi(TresciOdpowiedziDto trescOdpowiedzi);
}
