package com.ankiety.ankiety.service;

import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.dto.OsobyDto;
import com.ankiety.ankiety.model.dto.mapper.OsobyMapper;
import com.ankiety.ankiety.repository.OsobyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OsobyServiceImpl implements OsobyService {

    private final OsobyRepository osobyRepository;

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
    public Osoby addOsoba(Osoby osoba) {
        return osobyRepository.save(osoba);
    }
}
