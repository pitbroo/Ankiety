package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.dto.TresciOdpowiedziDto;
import com.ankiety.ankiety.repository.TresciOdpowiedziRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TresciOdpowiedziServiceImpl implements TresciOdpowiedziService {

    private final TresciOdpowiedziRepository tresciOdpowiedziRepository;

    public TresciOdpowiedziServiceImpl(TresciOdpowiedziRepository tresciOdpowiedziRepository) {
        this.tresciOdpowiedziRepository = tresciOdpowiedziRepository;
    }

    @Override
    public List<TresciOdpowiedziDto> getTresciOdpowiedzi() {
        return tresciOdpowiedziRepository.findAll()
                .stream()
                .map(TresciOdpowiedziDto::new)
                .collect(Collectors.toList());
    }
}
