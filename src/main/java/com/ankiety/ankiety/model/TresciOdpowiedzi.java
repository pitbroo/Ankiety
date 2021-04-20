package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class TresciOdpowiedzi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTresciOdpowiedzi;
    private String trescOdpowiedzi;

    public TresciOdpowiedzi() {

    }

    public TresciOdpowiedzi(int idTresciOdpowiedzi, String trescOdpowiedzi) {
        this.idTresciOdpowiedzi = idTresciOdpowiedzi;
        this.trescOdpowiedzi = trescOdpowiedzi;
    }

    public TresciOdpowiedzi(String trescOdpowiedzi) {
        this.trescOdpowiedzi = trescOdpowiedzi;
    }

}
