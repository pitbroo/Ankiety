package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.FilterOdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.KomentarzeDto;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import com.ankiety.ankiety.model.dto.IloscOdpowiedziDto;
import com.ankiety.ankiety.model.dto.mapper.AnkietyMapper;
import com.ankiety.ankiety.model.dto.mapper.OdpowiedziOsobMapper;
import com.ankiety.ankiety.model.dto.mapper.OsobyMapper;
import com.ankiety.ankiety.model.dto.mapper.TresciOdpowiedziMapper;
import com.ankiety.ankiety.repository.AnkietyRepository;
import com.ankiety.ankiety.repository.OdpowiedziOsobRepository;
import com.ankiety.ankiety.repository.OsobyRepository;
import com.ankiety.ankiety.repository.TresciOdpowiedziRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class OdpowiedziOsobServiceImpl implements OdpowiedziOsobService {

    private final OdpowiedziOsobRepository odpowiedziOsobRepository;
    private final AnkietyRepository ankietyRepository;
    public final AnkietyService ankietyService;
    private final OsobyRepository osobyRepository;
    private final TresciOdpowiedziRepository tresciOdpowiedziRepository;
    private final OsobyServiceImpl osobyService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public OdpowiedziOsobServiceImpl(OdpowiedziOsobRepository odpowiedziOsobRepository, AnkietyRepository ankietyRepository, AnkietyService ankietyService, OsobyRepository osobyRepository, TresciOdpowiedziRepository tresciOdpowiedziRepository, OsobyServiceImpl osobyService) {
        this.odpowiedziOsobRepository = odpowiedziOsobRepository;
        this.ankietyRepository = ankietyRepository;
        this.ankietyService = ankietyService;
        this.osobyRepository = osobyRepository;
        this.tresciOdpowiedziRepository = tresciOdpowiedziRepository;
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
        filterOdpowiedziOsobDto.forEach(post -> {
            if (!checkOdpowiedziOsob(post)) {
                odpowiedziOsobList.add(OdpowiedziOsobMapper.INSTANCE.odpowiedziOsobDtoToOdpowiedziOsob(new OdpowiedziOsobDto(OsobyMapper.INSTANCE.osobyToOsobyDto(osobyService.checkIpv4Exist(post.getIpv4())),
                        AnkietyMapper.INSTANCE.ankietyToAnkietyDto(ankietyRepository.findByNazwaAnkietyAndPytanie(post.getNazwaAnkiety(), post.getPytanie()).get()),
                        TresciOdpowiedziMapper.INSTACNE.TresciOdpowiedziToTresciOdpowiedziDto(tresciOdpowiedziRepository.findByTrescOdpowiedzi(post.getTrescOdpowiedzi()).get()),
                        new KomentarzeDto(post.getKomentarz()))));
            }
        });

        odpowiedziOsobRepository.saveAll(odpowiedziOsobList);
        return filterOdpowiedziOsobDto;
    }

    //sprawdzenie czy dana osoba odpowiedziała już na dana ankiete -> jeśli tak, zwróci true, jeśli nie to false
    public boolean checkOdpowiedziOsob(FilterOdpowiedziOsobDto filterOdpowiedziOsobDto) {

        Optional<Ankiety> ankietyOptional = ankietyRepository.findByNazwaAnkietyAndPytanie(filterOdpowiedziOsobDto.getNazwaAnkiety(), filterOdpowiedziOsobDto.getPytanie());
        Optional<Osoby> osobyOptional = osobyRepository.findByIPv4(filterOdpowiedziOsobDto.getIpv4());

        if (ankietyOptional.isPresent() && osobyOptional.isPresent()) {
            Ankiety ankieta = ankietyOptional.get();
            Osoby osoba = osobyOptional.get();

            //sprawdzenie czy w ankiecie jest taka odpowiedź
            if (ankieta.getTresciOdpowiedzi().stream().noneMatch(trescOdpowiedzi -> trescOdpowiedzi.getTrescOdpowiedzi().equals(filterOdpowiedziOsobDto.getTrescOdpowiedzi()))) {

                throw new IllegalArgumentException("W ankiecie '" + ankieta.getNazwaAnkiety() + "' nie ma odpowiedzi: '" + filterOdpowiedziOsobDto.getTrescOdpowiedzi() + "' na pytanie: '" + filterOdpowiedziOsobDto.getPytanie() + "'.");
            }

            if (odpowiedziOsobRepository.existsOdpowiedziOsobsByAnkietyAndOsoby(ankieta, osoba)) {
                System.out.println("Osoba o IPv4: " + osoba.getIPv4()
                        + " odpowiedziała już na pytanie: '"
                        + ankieta.getPytanie()
                        + "' w ankiecie: '"
                        + ankieta.getNazwaAnkiety()
                        + "'");
                return true;
            }
        }
        return false;
    }

    //metoda zliczająca ilości odpowiedzi na konkretne pytania w podanej ankiecie
    public List<IloscOdpowiedziDto> countOdpowiedziOsob(String nazwaAnkiety) {
        List<IloscOdpowiedziDto> iloscOdpowiedziDtoList = new ArrayList<>();

        List<String> ankietaPytania = ankietyService.getAnkietaPytania(nazwaAnkiety);
        ankietaPytania.forEach(pytanie -> {
            Optional<Ankiety> ankietaOptional = ankietyRepository.findByNazwaAnkietyAndPytanie(nazwaAnkiety, pytanie);
            if (ankietaOptional.isPresent()) {
                Ankiety ankieta = ankietaOptional.get();

                HashMap<String, Integer> odpowiedzIlosc = new HashMap<>();

                List<TresciOdpowiedzi> tresciOdpowiedziList = ankieta.getTresciOdpowiedzi();
                tresciOdpowiedziList.forEach(odpowiedz -> {

                    odpowiedzIlosc.put(odpowiedz.getTrescOdpowiedzi(), odpowiedziOsobRepository.countOdpowiedziOsobByAnkietyAndTresciOdpowiedzi(ankieta, odpowiedz));

                });
                iloscOdpowiedziDtoList.add(new IloscOdpowiedziDto(ankieta.getNazwaAnkiety(), pytanie, odpowiedzIlosc));
            }
        });
        return iloscOdpowiedziDtoList;
    }
}

