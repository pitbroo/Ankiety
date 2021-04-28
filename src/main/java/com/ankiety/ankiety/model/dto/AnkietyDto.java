package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class AnkietyDto {

    private int idPytania;
    @NotBlank(message = "Błąd nazwy ankiety")
    private String nazwaAnkiety;
    @NotBlank(message = "Błąd pytania")
    private String pytanie;
    private List<TresciOdpowiedziDto> tresciOdpowiedzi = new ArrayList<>();
    //private List<OdpowiedziOsob> odpowiedziOsobs = new ArrayList<>();

    public AnkietyDto() {
    }

   /* public AnkietyDto(Ankiety source) {
        this.idPytania = source.getIdPytania();
        this.nazwaAnkiety = source.getNazwaAnkiety();
        this.pytanie = source.getPytanie();
        this.tresciOdpowiedzi = source.getTresciOdpowiedzi().stream().map(TresciOdpowiedziDto::new).collect(Collectors.toList());
    }*/

}
