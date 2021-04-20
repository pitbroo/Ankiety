package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.TresciOdpowiedzi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TresciOdpowiedziDto {

    private int idTresciOdpowiedzi;
    private String trescOdpowiedzi;

    public TresciOdpowiedziDto() {
    }

    public TresciOdpowiedziDto(TresciOdpowiedzi source) {
        this.idTresciOdpowiedzi = source.getIdTresciOdpowiedzi();
        this.trescOdpowiedzi = source.getTrescOdpowiedzi();
    }

}
