package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OdpowiedziOsob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOdpowiedzi;
    @ManyToOne
    @JoinColumn(name = "id_osoby")
    private Osoby osoby;
    private int idPytania;
    private int idTresciOdpowiedzi;
}
