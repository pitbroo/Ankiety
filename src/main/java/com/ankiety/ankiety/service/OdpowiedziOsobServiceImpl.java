package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.repository.OdpowiedziOsobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdpowiedziOsobServiceImpl implements OdpowiedziOsobService {

    private final OdpowiedziOsobRepository odpowiedziOsobRepository;

    public OdpowiedziOsobServiceImpl(OdpowiedziOsobRepository odpowiedziOsobRepository) {
        this.odpowiedziOsobRepository = odpowiedziOsobRepository;
    }

    @Override
    public List<OdpowiedziOsobDto> getOdpowiedziOsob() {
        return odpowiedziOsobRepository.findAll()
                .stream()
                .map(OdpowiedziOsobDto::new)
                .collect(Collectors.toList());
    }
}
