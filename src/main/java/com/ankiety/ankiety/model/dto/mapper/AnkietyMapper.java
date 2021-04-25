package com.ankiety.ankiety.model.dto.mapper;

import com.ankiety.ankiety.model.Ankiety;
import com.ankiety.ankiety.model.dto.AnkietyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnkietyMapper {

    AnkietyMapper INSTANCE = Mappers.getMapper(AnkietyMapper.class);

    @Mapping(source = "idPytania", target = "idPytania")
    @Mapping(source = "nazwaAnkiety", target = "nazwaAnkiety")
    @Mapping(source = "pytanie", target = "pytanie")
    @Mapping(source = "tresciOdpowiedzi", target = "tresciOdpowiedzi")
    AnkietyDto ankietyToAnkietyDto(Ankiety ankiety);

    @Mapping(source = "idPytania", target = "idPytania")
    @Mapping(source = "nazwaAnkiety", target = "nazwaAnkiety")
    @Mapping(source = "pytanie", target = "pytanie")
    @Mapping(source = "tresciOdpowiedzi", target = "tresciOdpowiedzi")
    Ankiety ankietyDtoToAnkiety(AnkietyDto ankietyDto);
}
