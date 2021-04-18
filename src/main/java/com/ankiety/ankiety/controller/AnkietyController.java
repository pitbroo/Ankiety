package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.dto.AnkietyDto;
import com.ankiety.ankiety.service.AnkietyService;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ankiety")
@CrossOrigin("*")
public class AnkietyController {

    private AnkietyService ankietyService;

    public AnkietyController(AnkietyService ankietyService) {
        this.ankietyService = ankietyService;
    }

    @GetMapping
    public List<AnkietyDto> getAnkiety(){
        return ankietyService.getAnkiety();
    }

    @GetMapping("/{ankieta}")
    public List<String> getAnkietaPytania(@PathVariable String ankieta){
        return ankietyService.getAnkietaPytania(ankieta);
    }

    @GetMapping("/odpowiedzi/{ankieta}")
    public List<AnkietyDto> getAnkietyPytaniaOdpowiedzi(@PathVariable String ankieta){
        return ankietyService.getAnkietyPytaniaOdpowiedzi(ankieta);
    }

    @PostMapping
    public Ankiety addAnkieta(@RequestBody @Valid Ankiety ankiety){
        return ankietyService.addAnkiety(ankiety);
    }

    @GetMapping("/ankietyNazwy")
    public List<String> getAnkietyNazwa(){
        return ankietyService.getAnkietyNazwa();
    }



}
