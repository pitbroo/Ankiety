package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Ankiety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPytania;
    private String nazwaAnkiety;
    private String pytanie;


   //@JsonIgnoreProperties("ankiety")
    @ManyToMany
    @JoinTable(name = "odpowiedzi",
        joinColumns = {@JoinColumn(name = "id_pytania")},
        inverseJoinColumns = {@JoinColumn(name = "id_tresci_odpowiedzi") })
    private List<TresciOdpowiedzi> tresciOdpowiedzi;


    //@JsonIgnoreProperties("ankiety")
    @OneToMany(mappedBy = "ankiety")
    private List<OdpowiedziOsob> odpowiedziOsob;



}
