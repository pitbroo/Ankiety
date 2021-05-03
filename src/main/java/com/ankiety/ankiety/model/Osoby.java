package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Osoby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOsoby;
    @NotBlank(message = "Wartość IPv4 nie może być pusta!")
    private String IPv4;
    /*@OneToMany(mappedBy = "osoby")
    private List<OdpowiedziOsob> odpowiedziOsob;*/

    public Osoby() {
    }
}
