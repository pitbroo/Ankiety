package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.dto.FilterOdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.IloscOdpowiedziDto;
import com.ankiety.ankiety.service.OdpowiedziOsobService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
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

    @GetMapping("/{nazwaAnkiety}")
    public List<IloscOdpowiedziDto> countOdpowiedziOsob(@PathVariable String nazwaAnkiety){
         return odpowiedziOsobService.countOdpowiedziOsob(nazwaAnkiety);
    }

    @PostMapping
    public List<OdpowiedziOsob> addOdpowiedziOsob(@RequestBody List<OdpowiedziOsobDto> odpowiedziOsobDtoList){
       return odpowiedziOsobService.addOdpowiedziOsob(odpowiedziOsobDtoList);
    }

    @PostMapping("/listaOdpowiedzi")
    public List<FilterOdpowiedziOsobDto> addOdpowiedziDoAnkiety(@RequestBody List<@Valid FilterOdpowiedziOsobDto> filterOdpowiedziOsobDto){
       return odpowiedziOsobService.addOdpowiedziDoAnkiety(filterOdpowiedziOsobDto);
    }

}
