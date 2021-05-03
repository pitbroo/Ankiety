package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TresciOdpowiedziDto {

    private int idTresciOdpowiedzi;
    @NotBlank(message = "Treść odpowiedzi nie może być pusta")
    private String trescOdpowiedzi;

    public TresciOdpowiedziDto() {
    }

}
