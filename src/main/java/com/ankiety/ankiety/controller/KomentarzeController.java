package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.model.dto.KomentarzeDto;
import com.ankiety.ankiety.service.KomentarzeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/komentarze")
@CrossOrigin("*")
public class KomentarzeController {

    private final KomentarzeService komentarzeService;

    public KomentarzeController(KomentarzeService komentarzeService) {
        this.komentarzeService = komentarzeService;
    }

    @GetMapping
    public List<KomentarzeDto> getKomentarze(){
        return komentarzeService.getKomentarze();
    }

    @PostMapping
    public Komentarze addKomentarz(@RequestBody @Valid KomentarzeDto komentarzeDto){
        return komentarzeService.addKomentarz(komentarzeDto);
    }
}
