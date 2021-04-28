package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TresciOdpowiedziDto {

    private int idTresciOdpowiedzi;
    @NotBlank
    private String trescOdpowiedzi;

    public TresciOdpowiedziDto() {
    }

    /*public TresciOdpowiedziDto(TresciOdpowiedzi source) {
        this.idTresciOdpowiedzi = source.getIdTresciOdpowiedzi();
        this.trescOdpowiedzi = source.getTrescOdpowiedzi();
    }
*/
}
