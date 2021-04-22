package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.repository.KomentarzeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomentarzeServiceImpl implements KomentarzeService {

    private final KomentarzeRepository komentarzeRepository;

    public KomentarzeServiceImpl(KomentarzeRepository komentarzeRepository) {
        this.komentarzeRepository = komentarzeRepository;
    }

    @Override
    public List<Komentarze> getKomentarze() {
        return komentarzeRepository.findAll();
    }
}
