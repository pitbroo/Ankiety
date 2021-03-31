package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.Ankiety;

import java.util.List;
import java.util.stream.Collectors;

public class AnkietyDto {

    private int idPytania;
    private String nazwaAnkiety;
    private String pytanie;
    private List<TresciOdpowiedziDto> tresciOdpowiedzi;

    public AnkietyDto(Ankiety source) {
        this.idPytania = source.getIdPytania();
        this.nazwaAnkiety = source.getNazwaAnkiety();
        this.pytanie = source.getPytanie();
        this.tresciOdpowiedzi = source.getTresciOdpowiedzi().stream().map(TresciOdpowiedziDto::new).collect(Collectors.toList());
    }

    public int getIdPytania() {
        return idPytania;
    }

    public void setIdPytania(int idPytania) {
        this.idPytania = idPytania;
    }

    public String getNazwaAnkiety() {
        return nazwaAnkiety;
    }

    public void setNazwaAnkiety(String nazwaAnkiety) {
        this.nazwaAnkiety = nazwaAnkiety;
    }

    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public List<TresciOdpowiedziDto> getTresciOdpowiedzi() {
        return tresciOdpowiedzi;
    }

    public void setTresciOdpowiedzi(List<TresciOdpowiedziDto> tresciOdpowiedzi) {
        this.tresciOdpowiedzi = tresciOdpowiedzi;
    }
}
