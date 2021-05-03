package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.dto.PostFrontAnkiety;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.service.OdpowiedziOsobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odpowiedziOsob")
public class OdpowiedziOsobController {

    private final OdpowiedziOsobService odpowiedziOsobService;

    public OdpowiedziOsobController(OdpowiedziOsobService odpowiedziOsobService) {
        this.odpowiedziOsobService = odpowiedziOsobService;
    }

    @GetMapping
    public List<OdpowiedziOsobDto> getOdpowiedziOsob(){
        return odpowiedziOsobService.getOdpowiedziOsob();
    }
    /*@PostMapping
    public List<OdpowiedziOsob> addOdpowiedziOsob(@RequestBody List<OdpowiedziOsobDto> odpowiedziOsobDtoList){
       return odpowiedziOsobService.addOdpowiedziOsob(odpowiedziOsobDtoList);
    }*/

    @PostMapping("/test")
    public void dodajBrodziaka(@RequestBody PostFrontAnkiety postFrontAnkiety){
        odpowiedziOsobService.dodajBrodziaka(postFrontAnkiety);
    }

}
