package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.model.dto.KomentarzeDto;
import com.ankiety.ankiety.model.dto.mapper.KomentarzeMapper;
import com.ankiety.ankiety.repository.KomentarzeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KomentarzeServiceImpl implements KomentarzeService {

    private final KomentarzeRepository komentarzeRepository;

    public KomentarzeServiceImpl(KomentarzeRepository komentarzeRepository) {
        this.komentarzeRepository = komentarzeRepository;
    }

    @Override
    public List<KomentarzeDto> getKomentarze() {
        List<KomentarzeDto> listaDto = new ArrayList<>();
        komentarzeRepository.findAll()
                .forEach(komentarze -> {
                listaDto.add(KomentarzeMapper.INSTANCE.komenatrzeToKomentarzeDto(komentarze));
                });
        return listaDto;
    }

    @Override
    public Komentarze addKomentarz(KomentarzeDto komentarzeDto) {
        return komentarzeRepository.save(KomentarzeMapper.INSTANCE.komentarzeDtoToKomentarze(komentarzeDto));
    }
}
