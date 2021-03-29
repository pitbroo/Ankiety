package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class TresciOdpowiedzi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTresciOdpowiedzi;
    private String trescOdpowiedzi;

    @ManyToMany(mappedBy = "tresciOdpowiedzi")
    private Set<Ankiety> ankiety = new HashSet<>();
    @OneToMany(mappedBy = "tresciOdpowiedzi")
    private Set<OdpowiedziOsob> odpowiedziOsob;

    public TresciOdpowiedzi() {
    }
}
