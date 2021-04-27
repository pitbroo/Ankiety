package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Getter
@Setter
public class OdpowiedziOsobDto {

    @Null
    private int idOdpowiedzi;
    @NotBlank
    private Osoby osoby;
    @NotBlank
    private Ankiety ankiety;
    @NotBlank
    private TresciOdpowiedzi tresciOdpowiedzi;
    @NotBlank
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
