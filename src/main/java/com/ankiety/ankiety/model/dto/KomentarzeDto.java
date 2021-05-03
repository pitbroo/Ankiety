package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KomentarzeDto {

    //@NotNull
    private int idKomentarza;
    //@NotBlank
    private String trescKomentarza;

    public KomentarzeDto() {
    }

    public KomentarzeDto(String trescKomentarza) {
        this.trescKomentarza = trescKomentarza;
    }
}
