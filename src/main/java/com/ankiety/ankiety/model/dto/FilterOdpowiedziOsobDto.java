package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FilterOdpowiedziOsobDto {

    @NotBlank(message = "Wartość IPv4 nie może być pusta!")
    private String ipv4;
    private String nazwaAnkiety;
    private String pytanie;
    private String trescOdpowiedzi;
    private String komentarz;

    public FilterOdpowiedziOsobDto() {

    }

}
