package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdpowiedziOsobDto {


    private int idOdpowiedzi;
    //@NotBlank
    private OsobyDto osoby;
    //@NotBlank
    private AnkietyDto ankiety;
    //@NotBlank
    private TresciOdpowiedziDto tresciOdpowiedzi;
    //@NotBlank
    private KomentarzeDto komentarze;

    public OdpowiedziOsobDto() {
    }

    /*public OdpowiedziOsobDto(OdpowiedziOsob source) {
        this.idOdpowiedzi = source.getIdOdpowiedzi();
        this.osoby = source.getOsoby();
        this.ankiety = source.getAnkiety();
        this.tresciOdpowiedzi = source.getTresciOdpowiedzi();
        this.komentarze = source.getKomentarze();
    }*/

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
