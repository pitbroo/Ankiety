package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.mapper.OdpowiedziOsobMapper;
import com.ankiety.ankiety.repository.OdpowiedziOsobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdpowiedziOsobServiceImpl implements OdpowiedziOsobService {

    private final OdpowiedziOsobRepository odpowiedziOsobRepository;

    public OdpowiedziOsobServiceImpl(OdpowiedziOsobRepository odpowiedziOsobRepository) {
        this.odpowiedziOsobRepository = odpowiedziOsobRepository;
    }

    @Override
    public List<OdpowiedziOsobDto> getOdpowiedziOsob() {
        List<OdpowiedziOsobDto> odpowiedziOsobDtoList = new ArrayList<>();
        odpowiedziOsobRepository.findAll()
                .forEach(odpowiedziOsob -> {
                    odpowiedziOsobDtoList.add(OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobToOdpowiedziOsobDto(odpowiedziOsob));
                });
        return odpowiedziOsobDtoList;
    }
}
