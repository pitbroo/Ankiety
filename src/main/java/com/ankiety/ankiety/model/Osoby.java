package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Osoby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOsoby;
    private int IPv4;
    @OneToMany(mappedBy = "osoby")
    private Set<OdpowiedziOsob> odpowiedziOsob;
}
