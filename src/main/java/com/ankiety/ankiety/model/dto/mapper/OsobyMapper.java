package com.ankiety.ankiety.model.dto.mapper;


import com.ankiety.ankiety.model.Osoby;
import com.ankiety.ankiety.model.dto.OsobyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OsobyMapper {
    OsobyMapper INSTANCE = Mappers.getMapper(OsobyMapper.class);

    @Mapping(source = "idOsoby", target = "idOsoby")
    @Mapping(source = "IPv4", target = "IPv4")
    OsobyDto osobyToOsobyDto(Osoby osoby);

    @Mapping(source = "idOsoby", target = "idOsoby")
    @Mapping(source = "IPv4", target = "IPv4")
    Osoby osobyDtoToOsoby(OsobyDto osobyDto);

}
