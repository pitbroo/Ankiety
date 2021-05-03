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
    @ManyToOne
    @JoinColumn(name = "id_pytania")
    private Ankiety ankiety;
    @ManyToOne
    @JoinColumn(name = "id_tresci_odpowiedzi")
    private TresciOdpowiedzi tresciOdpowiedzi;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_komentarza")
    private Komentarze komentarze;

    public OdpowiedziOsob() {
    }

}
