package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class KomentarzeDto {

    @NotNull
    private int idKomentarza;
    @NotBlank
    private String trescKomentarza;

    public KomentarzeDto() {
    }

}
