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

    public TresciOdpowiedzi() {

    }

    public TresciOdpowiedzi(int idTresciOdpowiedzi, String trescOdpowiedzi) {
        this.idTresciOdpowiedzi = idTresciOdpowiedzi;
        this.trescOdpowiedzi = trescOdpowiedzi;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tresciOdpowiedzi")
    private List<Ankiety> ankiety = new ArrayList<>();

    /*@OneToMany(mappedBy = "tresciOdpowiedzi")
    private List<OdpowiedziOsob> odpowiedziOsob = new ArrayList();*/

    public int getIdTresciOdpowiedzi() {
        return idTresciOdpowiedzi;
    }

    public void setIdTresciOdpowiedzi(int idTresciOdpowiedzi) {
        this.idTresciOdpowiedzi = idTresciOdpowiedzi;
    }

    public String getTrescOdpowiedzi() {
        return trescOdpowiedzi;
    }

    public void setTrescOdpowiedzi(String trescOdpowiedzi) {
        this.trescOdpowiedzi = trescOdpowiedzi;
    }

    public List<Ankiety> getAnkiety() {
        return ankiety;
    }

    public void setAnkiety(List<Ankiety> ankiety) {
        this.ankiety = ankiety;
    }
}
