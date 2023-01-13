package com.projet.AKB.dtos.compte;

import com.projet.AKB.entities.Compte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompteMapper {

    @Mapping(source = "idcpt", target = "idcptTO")
    @Mapping(source = "mailcpt", target = "mailcptTO")
    @Mapping(source = "photoprofilcpt", target = "photoprofilcptTO")
    @Mapping(source = "motdepassecpt", target = "motdepassecptTO")
    @Mapping(source = "user", target = "userTO")
    @Mapping(source = "reservation", target = "reservationsTO")
    @Mapping(source = "vehicules", target = "vehiculesTO")
    CompteTO toDTO(Compte d);

    Compte toEntity(CompteTO d);

}
