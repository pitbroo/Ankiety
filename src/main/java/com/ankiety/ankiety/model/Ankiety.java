package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Ankiety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPytania;
    private String nazwaAnkiety;
    private String pytanie;

    @ManyToMany
    @JoinTable(name = "odpowiedzi",
        joinColumns = {@JoinColumn(name = "id_pytania")},
        inverseJoinColumns = {@JoinColumn(name = "id_tresci_odpowiedzi") })
    private Set<TresciOdpowiedzi> tresciOdpowiedzi = new HashSet<>();

    @OneToMany(mappedBy = "ankiety")
    private Set<OdpowiedziOsob> odpowiedziOsob;

    public Ankiety() {
    }


    //komętarz
}
