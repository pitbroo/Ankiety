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
    @NotBlank(message = "Ankieta musi mieć nazwę")
    private String nazwaAnkiety;
    @NotBlank(message = "Pytanie musi zawierać treść")
    private String pytanie;
    private List<TresciOdpowiedziDto> tresciOdpowiedzi = new ArrayList<>();

    public AnkietyDto() {
    }
}
