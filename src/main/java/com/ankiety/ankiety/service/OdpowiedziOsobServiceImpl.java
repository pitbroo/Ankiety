package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.dto.PostFrontAnkiety;
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

    public OdpowiedziOsobServiceImpl(OdpowiedziOsobRepository odpowiedziOsobRepository, AnkietyRepository ankietyRepository, OsobyRepository osobyRepository, TresciOdpowiedziRepository tresciOdpowiedziRepository, KomentarzeRepository komentarzeRepository) {
        this.odpowiedziOsobRepository = odpowiedziOsobRepository;
        this.ankietyRepository = ankietyRepository;
        this.osobyRepository = osobyRepository;
        this.tresciOdpowiedziRepository = tresciOdpowiedziRepository;
        this.komentarzeRepository = komentarzeRepository;
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

    //testownie dodawania odpowiedzi osób
    @Override
    public List<OdpowiedziOsob> addOdpowiedziOsob(List<OdpowiedziOsobDto> odpowiedziOsobDtoList) {

        /*odpowiedziOsobDto.setOsoby(OsobyMapper.INSTANCE.osobyToOsobyDto(osobyRepository.findByIdOsoby(1)));
        odpowiedziOsobDto.setAnkiety(AnkietyMapper.INSTANCE.ankietyToAnkietyDto( ankietyRepository.findByIdPytania(2)));
        odpowiedziOsobDto.setTresciOdpowiedzi(TresciOdpowiedziMapper.INSTACNE.TresciOdpowiedziToTresciOdpowiedziDto(tresciOdpowiedziRepository.findByIdTresciOdpowiedzi(3)));
        odpowiedziOsobDto.setKomentarze(KomentarzeMapper.INSTANCE.komenatrzeToKomentarzeDto(komentarzeRepository.findByIdKomentarza(4)));*/
        //OdpowiedziOsob odpowiedziOsob = OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobDtoToOdpowiedziOsob(odpowiedziOsobDto);
        //odpowiedziOsob.setKomentarze(komentarzeRepository.findByIdKomentarza(4));
        List<OdpowiedziOsob> odpowiedziOsobList = new ArrayList<>();
        odpowiedziOsobDtoList.forEach(odpowiedziOsobDto -> {
            odpowiedziOsobList.add(OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobDtoToOdpowiedziOsob(odpowiedziOsobDto));
        });

        return odpowiedziOsobRepository.saveAll(odpowiedziOsobList);
    }

    @Override
    public void dodajBrodziaka(PostFrontAnkiety postFrontAnkiety) {
        OdpowiedziOsobDto odpowiedziOsobDto = new OdpowiedziOsobDto();
        odpowiedziOsobDto.setOsoby(OsobyMapper.INSTANCE.osobyToOsobyDto(osobyRepository.findByIPv4(postFrontAnkiety.getIpv4())));
        odpowiedziOsobDto.setAnkiety(AnkietyMapper.INSTANCE.ankietyToAnkietyDto(ankietyRepository.findByNazwaAnkietyAndPytanie(postFrontAnkiety.getNazwaAnkiety(), postFrontAnkiety.getPytanie())));
        odpowiedziOsobDto.setTresciOdpowiedzi(TresciOdpowiedziMapper.INSTACNE.TresciOdpowiedziToTresciOdpowiedziDto(tresciOdpowiedziRepository.findByTrescOdpowiedzi(postFrontAnkiety.getTrescOdpowiedzi()).get()));
        odpowiedziOsobDto.setKomentarze(new KomentarzeDto(postFrontAnkiety.getKomentarz()));
        odpowiedziOsobRepository.save(OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobDtoToOdpowiedziOsob(odpowiedziOsobDto));

    }
}
