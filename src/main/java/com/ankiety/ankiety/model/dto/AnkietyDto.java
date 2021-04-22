package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.Ankiety;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class AnkietyDto {

    private int idPytania;
    private String nazwaAnkiety;
    private String pytanie;
    private List<TresciOdpowiedziDto> tresciOdpowiedzi = new ArrayList<>();
    //private List<OdpowiedziOsob> odpowiedziOsobs = new ArrayList<>();

    public AnkietyDto() {
    }

    public AnkietyDto(Ankiety source) {
        this.idPytania = source.getIdPytania();
        this.nazwaAnkiety = source.getNazwaAnkiety();
        this.pytanie = source.getPytanie();
        this.tresciOdpowiedzi = source.getTresciOdpowiedzi().stream().map(TresciOdpowiedziDto::new).collect(Collectors.toList());
    }

}
