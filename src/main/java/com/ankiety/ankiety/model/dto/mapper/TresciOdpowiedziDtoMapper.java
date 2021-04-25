package com.ankiety.ankiety.model.dto.mapper;

import com.ankiety.ankiety.model.TresciOdpowiedzi;
import com.ankiety.ankiety.model.dto.TresciOdpowiedziDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TresciOdpowiedziDtoMapper {
    TresciOdpowiedziDtoMapper INSTACNE = Mappers.getMapper(TresciOdpowiedziDtoMapper.class);

    @Mapping(source = "idTresciOdpowiedzi", target = "idTresciOdpowiedzi")
    @Mapping(source = "trescOdpowiedzi", target = "trescOdpowiedzi")
    TresciOdpowiedziDto TresciOdpowiedziToTresciOdpowiedziDto(TresciOdpowiedzi tresciOdpowiedzi);

    @Mapping(source = "idTresciOdpowiedzi", target = "idTresciOdpowiedzi")
    @Mapping(source = "trescOdpowiedzi", target = "trescOdpowiedzi")
    TresciOdpowiedzi TresciOdpowiedziDtoToTresciOdpowiedzi(TresciOdpowiedziDto tresciOdpowiedziDto);
}
