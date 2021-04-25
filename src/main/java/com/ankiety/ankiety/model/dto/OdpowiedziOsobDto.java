package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdpowiedziOsobDto {

    private int idOdpowiedzi;
    private Osoby osoby;
    private Ankiety ankiety;
    private TresciOdpowiedzi tresciOdpowiedzi;
    private Komentarze komentarze;

    public OdpowiedziOsobDto() {
    }

    /*public OdpowiedziOsobDto(OdpowiedziOsob source) {
        this.idOdpowiedzi = source.getIdOdpowiedzi();
        this.osoby = source.getOsoby();
        this.ankiety = source.getAnkiety();
        this.tresciOdpowiedzi = source.getTresciOdpowiedzi();
        this.komentarze = source.getKomentarze();
    }*/
}
