package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Komentarze {

    @Id
    private int idOdpowiedzi;
    private String trescKomentarza;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_odpowiedzi")
    private OdpowiedziOsob odpowiedziOsob;
}
