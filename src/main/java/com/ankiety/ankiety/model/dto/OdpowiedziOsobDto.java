package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdpowiedziOsobDto {


    private int idOdpowiedzi;
    private OsobyDto osoby;
    private AnkietyDto ankiety;
    private TresciOdpowiedziDto tresciOdpowiedzi;
    private KomentarzeDto komentarze;

    public OdpowiedziOsobDto() {
    }

    public OdpowiedziOsobDto(OsobyDto osoby, AnkietyDto ankiety, TresciOdpowiedziDto tresciOdpowiedzi, KomentarzeDto komentarze) {
        this.osoby = osoby;
        this.ankiety = ankiety;
        this.tresciOdpowiedzi = tresciOdpowiedzi;
        this.komentarze = komentarze;
    }

    @Override
    public String toString() {
        return "OdpowiedziOsobDto{" +
                "idOdpowiedzi=" + idOdpowiedzi +
                ", osoby=" + osoby +
                ", ankiety=" + ankiety +
                ", tresciOdpowiedzi=" + tresciOdpowiedzi +
                ", komentarze=" + komentarze +
                '}';
    }
}
