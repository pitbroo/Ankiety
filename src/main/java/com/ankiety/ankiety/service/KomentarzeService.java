package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.model.dto.KomentarzeDto;

import java.util.List;

public interface KomentarzeService {
    List<KomentarzeDto> getKomentarze();
    Komentarze addKomentarz(KomentarzeDto komentarzeDto);

}
