package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
public class Osoby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOsoby;
    @NotBlank(message = "Wartość IPv4 nie może być pusta!")
    private String IPv4;
    @OneToMany(mappedBy = "osoby")
    private List<OdpowiedziOsob> odpowiedziOsob;
}
