package com.ankiety.ankiety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Osoby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOsoby;
    private int ipv4;
}
