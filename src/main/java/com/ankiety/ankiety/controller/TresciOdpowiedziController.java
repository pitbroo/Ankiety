package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.TresciOdpowiedziDto;
import com.ankiety.ankiety.service.TresciOdpowiedziService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tresciodpowiedzi")
@CrossOrigin("*")
public class TresciOdpowiedziController {

    private final TresciOdpowiedziService tresciOdpowiedziService;

    public TresciOdpowiedziController(TresciOdpowiedziService tresciOdpowiedziService) {
        this.tresciOdpowiedziService = tresciOdpowiedziService;
    }

    @GetMapping
    public List<TresciOdpowiedziDto> getTresciOdpowiedzi(){
        return tresciOdpowiedziService.getTresciOdpowiedzi();
    }

    @PostMapping
    public TresciOdpowiedzi addTrescOdpowiedzi(@RequestBody @Valid TresciOdpowiedziDto trescOdpowiedziDto){
        return tresciOdpowiedziService.addTrescOdpowiedzi(trescOdpowiedziDto);
    }
}
