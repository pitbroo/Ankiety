package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.dto.FilterOdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.KomentarzeDto;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.mapper.AnkietyMapper;
import com.ankiety.ankiety.model.dto.mapper.OdpowiedziOsobMapper;
import com.ankiety.ankiety.model.dto.mapper.OsobyMapper;
import com.ankiety.ankiety.model.dto.mapper.TresciOdpowiedziMapper;
import com.ankiety.ankiety.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdpowiedziOsobServiceImpl implements OdpowiedziOsobService {

    private final OdpowiedziOsobRepository odpowiedziOsobRepository;
    private final AnkietyRepository ankietyRepository;
    private final OsobyRepository osobyRepository;
    private final TresciOdpowiedziRepository tresciOdpowiedziRepository;
    private final KomentarzeRepository komentarzeRepository;
    private final OsobyServiceImpl osobyService;

    public OdpowiedziOsobServiceImpl(OdpowiedziOsobRepository odpowiedziOsobRepository, AnkietyRepository ankietyRepository, OsobyRepository osobyRepository, TresciOdpowiedziRepository tresciOdpowiedziRepository, KomentarzeRepository komentarzeRepository, OsobyServiceImpl osobyService) {
        this.odpowiedziOsobRepository = odpowiedziOsobRepository;
        this.ankietyRepository = ankietyRepository;
        this.osobyRepository = osobyRepository;
        this.tresciOdpowiedziRepository = tresciOdpowiedziRepository;
        this.komentarzeRepository = komentarzeRepository;
        this.osobyService = osobyService;
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

    @Override
    public List<OdpowiedziOsob> addOdpowiedziOsob(List<OdpowiedziOsobDto> odpowiedziOsobDtoList) {
        List<OdpowiedziOsob> odpowiedziOsobList = new ArrayList<>();
        odpowiedziOsobDtoList.forEach(odpowiedziOsobDto -> {
            odpowiedziOsobList.add(OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobDtoToOdpowiedziOsob(odpowiedziOsobDto));
        });

        return odpowiedziOsobRepository.saveAll(odpowiedziOsobList);
    }

    @Override
    public List<FilterOdpowiedziOsobDto> addOdpowiedziDoAnkiety(List<FilterOdpowiedziOsobDto> filterOdpowiedziOsobDto) {
        List<OdpowiedziOsob> odpowiedziOsobList = new ArrayList<>();
        filterOdpowiedziOsobDto.forEach(post ->{
            odpowiedziOsobList.add(OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobDtoToOdpowiedziOsob(new OdpowiedziOsobDto(OsobyMapper.INSTANCE.osobyToOsobyDto(osobyService.checkIpv4Exist(post.getIpv4())),
                                        AnkietyMapper.INSTANCE.ankietyToAnkietyDto(ankietyRepository.findByNazwaAnkietyAndPytanie(post.getNazwaAnkiety(), post.getPytanie())),
                                        TresciOdpowiedziMapper.INSTACNE.TresciOdpowiedziToTresciOdpowiedziDto(tresciOdpowiedziRepository.findByTrescOdpowiedzi(post.getTrescOdpowiedzi()).get()),
                                        new KomentarzeDto(post.getKomentarz()))));
        });

        odpowiedziOsobRepository.saveAll(odpowiedziOsobList);
        return filterOdpowiedziOsobDto;
    }
}
