package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.repository.OsobyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/osoby")
public class OsobyController {

    private final OsobyRepository osobyRepository;

    public OsobyController(OsobyRepository osobyRepository) {
        this.osobyRepository = osobyRepository;
    }

    @GetMapping
    public List<Osoby> getOsoby(){
        return osobyRepository.findAll();
    }

    @PostMapping
    public Osoby addOsoby(@RequestBody Osoby osoby){
        return osobyRepository.save(osoby);
    }
}
