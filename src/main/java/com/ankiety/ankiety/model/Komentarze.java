package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Komentarze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKomentarza;
    private String trescKomentarza;

    public Komentarze() {
    }
}
