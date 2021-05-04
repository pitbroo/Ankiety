package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.TresciOdpowiedziDto;
import com.ankiety.ankiety.model.dto.mapper.TresciOdpowiedziMapper;
import com.ankiety.ankiety.repository.TresciOdpowiedziRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TresciOdpowiedziServiceImpl implements TresciOdpowiedziService {

    private final TresciOdpowiedziRepository tresciOdpowiedziRepository;

    public TresciOdpowiedziServiceImpl(TresciOdpowiedziRepository tresciOdpowiedziRepository) {
        this.tresciOdpowiedziRepository = tresciOdpowiedziRepository;
    }

    @Override
    public List<TresciOdpowiedziDto> getTresciOdpowiedzi() {
        List<TresciOdpowiedziDto> tresciOdpowiedziDtoList = new ArrayList<>();
        tresciOdpowiedziRepository.findAll()
                .forEach(tresciOdpowiedzi -> {
                    tresciOdpowiedziDtoList.add(TresciOdpowiedziMapper.INSTACNE.TresciOdpowiedziToTresciOdpowiedziDto(tresciOdpowiedzi));
                });
        return tresciOdpowiedziDtoList;
    }

    @Override
    public TresciOdpowiedzi addTrescOdpowiedzi(TresciOdpowiedziDto trescOdpowiedzi) {

        if(tresciOdpowiedziRepository.existsByTrescOdpowiedzi(trescOdpowiedzi.getTrescOdpowiedzi())){
            throw new IllegalStateException("Odpowiedz '" + trescOdpowiedzi.getTrescOdpowiedzi() + "' juz jest w bazie danych.");
        }
            return tresciOdpowiedziRepository.save(TresciOdpowiedziMapper.INSTACNE.TresciOdpowiedziDtoToTresciOdpowiedzi(trescOdpowiedzi));
    }
}
