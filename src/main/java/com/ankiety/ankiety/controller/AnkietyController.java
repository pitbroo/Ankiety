package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.dto.AnkietyDto;
import com.ankiety.ankiety.service.AnkietyService;
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
    public List<AnkietyDto> getAnkietyByNazwa(@PathVariable String ankieta){
        return ankietyService.getAnkietyByNazwa(ankieta);
    }

    @GetMapping("/ankietyNazwy")
    public List<String> getAnkietyNazwa(){
        return ankietyService.getAnkietyNazwa();
    }

    @GetMapping("/pytania/{ankieta}")
    public List<String> getAnkietaPytania(@PathVariable String ankieta){
        return ankietyService.getAnkietaPytania(ankieta);
    }

    @PostMapping
    public Ankiety addAnkieta(@RequestBody @Valid AnkietyDto ankiety){
        return ankietyService.addAnkiety(ankiety);
    }
}
