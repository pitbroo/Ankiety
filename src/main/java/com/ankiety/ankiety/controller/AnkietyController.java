package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.service.AnkietyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ankiety")
public class AnkietyController {

    private AnkietyService ankietyService;

    public AnkietyController(AnkietyService ankietyService) {
        this.ankietyService = ankietyService;
    }

    @PostMapping
    public Ankiety addAnkieta(@RequestBody Ankiety ankiety){
        return ankietyService.addAnkiety(ankiety);
    }

    @GetMapping
    public List<Ankiety> getAnkiety(){
        return ankietyService.getAnkiety();
    }
}
