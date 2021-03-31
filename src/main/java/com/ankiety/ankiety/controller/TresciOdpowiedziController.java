package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.dto.TresciOdpowiedziDto;
import com.ankiety.ankiety.service.TresciOdpowiedziService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tresciodpowiedzi")
public class TresciOdpowiedziController {

    private final TresciOdpowiedziService tresciOdpowiedziService;


    public TresciOdpowiedziController(TresciOdpowiedziService tresciOdpowiedziService) {
        this.tresciOdpowiedziService = tresciOdpowiedziService;
    }

    @GetMapping
    public List<TresciOdpowiedziDto> getTresciOdpowiedzi(){
        return tresciOdpowiedziService.getTresciOdpowiedzi();
    }
}
