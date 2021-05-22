package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.dto.OsobyDto;
import com.ankiety.ankiety.service.OsobyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/osoby")
@CrossOrigin("*")
public class OsobyController {

    private final OsobyService osobyService;

    public OsobyController(OsobyService osobyService) {
        this.osobyService = osobyService;
    }

    @GetMapping
    public List<OsobyDto> getOsoby(){
        return osobyService.getOsoby();
    }

    @PostMapping
    public Osoby addOsoby(@RequestBody @Valid OsobyDto osobaDto){
        return osobyService.addOsoba(osobaDto);
    }
}
