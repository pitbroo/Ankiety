package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OsobyDto {


    private int idOsoby;
    @NotBlank(message = "Wartość IPv4 nie może być pusta!")
    private String IPv4;

    public OsobyDto() {
    }

    public OsobyDto(String IPv4) {
        this.IPv4 = IPv4;
    }
}
