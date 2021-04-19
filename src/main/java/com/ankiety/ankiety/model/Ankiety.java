package com.ankiety.ankiety.model;

import com.ankiety.ankiety.model.dto.AnkietyDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Ankiety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPytania;
    private String nazwaAnkiety;
    private String pytanie;

    public Ankiety() {
    }

    public Ankiety(AnkietyDto source) {
        this.idPytania = source.getIdPytania();
        this.nazwaAnkiety = source.getNazwaAnkiety();
        this.pytanie = source.getPytanie();
        this.tresciOdpowiedzi = source.getTresciOdpowiedzi()
                .stream()
                .map(tresciOdpowiedzi ->
                        new TresciOdpowiedzi(
                                tresciOdpowiedzi.getIdTresciOdpowiedzi(),
                                tresciOdpowiedzi.getTrescOdpowiedzi()))
                .collect(Collectors.toList());
        this.odpowiedziOsob = source.getOdpowiedziOsobs();
    }

    //@JsonIgnoreProperties("ankiety")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "odpowiedzi",
        joinColumns = {@JoinColumn(name = "id_pytania")},
        inverseJoinColumns = {@JoinColumn(name = "id_tresci_odpowiedzi") })
    private List<TresciOdpowiedzi> tresciOdpowiedzi;


    //@JsonIgnoreProperties("ankiety")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ankiety")
    private List<OdpowiedziOsob> odpowiedziOsob;


}
