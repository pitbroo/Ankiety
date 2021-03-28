package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ankiety")
public class Ankiety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPytania;
    private String nazwaAnkiety;
    private String pytanie;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "odpowiedzi",
        joinColumns = {@JoinColumn(name = "id_pytania")},
        inverseJoinColumns = {@JoinColumn(name = "id_tresci_odpowiedzi") })
    private Set<TresciOdpowiedzi> tresciOdpowiedzi = new HashSet<>();

    public Ankiety() {
    }
}
