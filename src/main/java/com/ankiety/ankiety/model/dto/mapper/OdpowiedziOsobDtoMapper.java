package com.ankiety.ankiety.model.dto.mapper;

import com.ankiety.ankiety.model.OdpowiedziOsob;
import com.ankiety.ankiety.model.dto.OdpowiedziOsobDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OdpowiedziOsobDtoMapper {

    OdpowiedziOsobDtoMapper INSTANCE = Mappers.getMapper(OdpowiedziOsobDtoMapper.class);

    @Mapping(source = "idOdpowiedzi", target = "idOdpowiedzi")
    @Mapping(source = "osoby", target = "osoby")
    @Mapping(source = "ankiety", target = "ankiety")
    @Mapping(source = "tresciOdpowiedzi", target = "tresciOdpowiedzi")
    @Mapping(source = "komentarze", target = "komentarze")
    OdpowiedziOsobDto odpowiedziOsobToOdpowiedziOsobDto(OdpowiedziOsob odpowiedziOsob);

    @Mapping(source = "idOdpowiedzi", target = "idOdpowiedzi")
    @Mapping(source = "osoby", target = "osoby")
    @Mapping(source = "ankiety", target = "ankiety")
    @Mapping(source = "tresciOdpowiedzi", target = "tresciOdpowiedzi")
    @Mapping(source = "komentarze", target = "komentarze")
    OdpowiedziOsob odpowiedziOsobDtoToOdpowiedziOsob(OdpowiedziOsobDto odpowiedziOsobDto);
}
