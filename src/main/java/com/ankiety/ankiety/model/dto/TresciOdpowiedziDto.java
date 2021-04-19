package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.TresciOdpowiedzi;

public class TresciOdpowiedziDto {

    private int idTresciOdpowiedzi;
    private String trescOdpowiedzi;

    public TresciOdpowiedziDto() {
    }

    public TresciOdpowiedziDto(TresciOdpowiedzi source) {
        this.idTresciOdpowiedzi = source.getIdTresciOdpowiedzi();
        this.trescOdpowiedzi = source.getTrescOdpowiedzi();
    }

    public int getIdTresciOdpowiedzi() {
        return idTresciOdpowiedzi;
    }

    public void setIdTresciOdpowiedzi(int idTresciOdpowiedzi) {
        this.idTresciOdpowiedzi = idTresciOdpowiedzi;
    }

    public String getTrescOdpowiedzi() {
        return trescOdpowiedzi;
    }

    public void setTrescOdpowiedzi(String trescOdpowiedzi) {
        this.trescOdpowiedzi = trescOdpowiedzi;
    }
}
