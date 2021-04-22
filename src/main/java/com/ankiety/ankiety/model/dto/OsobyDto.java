package com.ankiety.ankiety.model.dto;

import com.ankiety.ankiety.model.Osoby;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OsobyDto {

    private int idOsoby;
    private String IPv4;

    public OsobyDto() {
    }

    public OsobyDto(Osoby source) {
        this.idOsoby = source.getIdOsoby();
        this.IPv4 = source.getIPv4();
    }
}
