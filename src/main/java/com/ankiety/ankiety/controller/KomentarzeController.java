package com.ankiety.ankiety.controller;

import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.service.KomentarzeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/komentarze")
public class KomentarzeController {

    private final KomentarzeService komentarzeService;

    public KomentarzeController(KomentarzeService komentarzeService) {
        this.komentarzeService = komentarzeService;
    }

    @GetMapping
    public List<Komentarze> getKomentarze(){
        return komentarzeService.getKomentarze();
    }
}
