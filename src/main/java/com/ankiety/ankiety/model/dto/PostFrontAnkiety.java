package com.ankiety.ankiety.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFrontAnkiety {

    String ipv4;
    String nazwaAnkiety;
    String pytanie;
    String trescOdpowiedzi;
    String komentarz;

    public PostFrontAnkiety() {
    }

}
