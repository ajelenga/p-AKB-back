package com.projet.AKB.dtos.user;

import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.User;
import com.projet.AKB.entities.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source ="idusr", target = "idusrTO")
    @Mapping(source ="nomusr", target = "nomusrTO")
    @Mapping(source ="prenomusr", target = "prenomusrTO")
    @Mapping(source ="datenaissance", target = "datenaissanceTO")
    @Mapping(source ="adresseusr", target = "adresseusrTO")
    @Mapping(source ="codepostaleusr", target = "codepostaleusrTO")
    @Mapping(source ="pieceidentiteusr", target = "pieceidentiteusrTO")
    @Mapping(source ="sexeusr", target = "sexeusrTO")
    UserTO toDTO(User d);
    User toEntity(UserTO d);


}
