package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class TresciOdpowiedzi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTresciOdpowiedzi;
    private String trescOdpowiedzi;


    @ManyToMany(mappedBy = "tresciOdpowiedzi")
    private List<Ankiety> ankiety = new ArrayList<>();

    /*@OneToMany(mappedBy = "tresciOdpowiedzi")
    private List<OdpowiedziOsob> odpowiedziOsob = new ArrayList();*/


}
