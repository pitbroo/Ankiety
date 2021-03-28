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

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "tresciOdpowiedzi")
    private Set<Ankiety> ankiety = new HashSet<>();

    public TresciOdpowiedzi() {
    }
}
