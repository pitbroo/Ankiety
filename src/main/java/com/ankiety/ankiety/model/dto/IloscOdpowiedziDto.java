package com.ankiety.ankiety.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class IloscOdpowiedziDto {
    private String nazwaAnkiety;
    private String pytanie;
    private HashMap<String, Integer> odpowiedzIlosc = new HashMap<>();

    public IloscOdpowiedziDto() {
    }
}
