package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.service.OdpowiedziOsobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
