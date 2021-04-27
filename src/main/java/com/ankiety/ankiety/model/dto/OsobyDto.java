package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OsobyDto {

    @NotNull
    private int idOsoby;
    @NotBlank
    private String IPv4;

    public OsobyDto() {
    }

    /*public OsobyDto(Osoby source) {
        this.idOsoby = source.getIdOsoby();
        this.IPv4 = source.getIPv4();
    }*/
}
