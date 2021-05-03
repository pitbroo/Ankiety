package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.dto.OsobyDto;
import com.ankiety.ankiety.model.dto.mapper.OsobyMapper;
import com.ankiety.ankiety.repository.OsobyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OsobyServiceImpl implements OsobyService {

    private final OsobyRepository osobyRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public OsobyServiceImpl(OsobyRepository osobyRepository) {
        this.osobyRepository = osobyRepository;
    }

    @Override
    public List<OsobyDto> getOsoby() {
       List<OsobyDto> osobyDtoList = new ArrayList<>();
       osobyRepository.findAll()
               .forEach(osoba -> {
                   osobyDtoList.add(OsobyMapper.INSTANCE.osobyToOsobyDto(osoba));
               });
       return  osobyDtoList;
    }

    @Override
    public Osoby addOsoba(OsobyDto osoba) {
        Osoby osoby = checkIpv4Exist(osoba.getIPv4());
        return osobyRepository.save(osoby);
    }

    //sprawdzenie czy IPv4 już istnieje w bazie
    public Osoby checkIpv4Exist(String ipv4){
        if(osobyRepository.findByIPv4(ipv4).isPresent()){
            logger.info("IPv4: '" + ipv4 + "' jest już w bazie danych");
            return osobyRepository.findByIPv4(ipv4).get();
        }else {
            logger.info("IPv4: '" + ipv4 + "' zostanie dodane do bazy danych");
            return osobyRepository.save(OsobyMapper.INSTANCE.osobyDtoToOsoby(new OsobyDto(ipv4)));
        }
    }
}
