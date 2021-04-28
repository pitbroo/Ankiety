package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.TresciOdpowiedzi;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OdpowiedziOsobDto {


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
