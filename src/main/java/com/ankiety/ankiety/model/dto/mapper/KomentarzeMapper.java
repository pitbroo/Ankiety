package com.ankiety.ankiety.model.dto.mapper;

import com.ankiety.ankiety.model.Komentarze;
import com.ankiety.ankiety.model.dto.KomentarzeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KomentarzeMapper {

    KomentarzeMapper INSTANCE = Mappers.getMapper(KomentarzeMapper.class);

    @Mapping(source = "idKomentarza", target = "idKomentarza")
    @Mapping(source = "trescKomentarza", target = "trescKomentarza")
    KomentarzeDto komenatrzeToKomentarzeDto(Komentarze komentarze);

    @Mapping(source = "idKomentarza", target = "idKomentarza")
    @Mapping(source = "trescKomentarza", target = "trescKomentarza")
    Komentarze komentarzeDtoToKomentarze(KomentarzeDto komentarzeDto);
}
