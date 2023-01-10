
package com.projet.AKB.dtos.vehicule;


import com.projet.AKB.entities.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehiculeMapper  {


    @Mapping(source ="idvcl", target = "idvclTO", ignore = true)
    @Mapping(source ="marquevcl", target = "marquevclTO")
    @Mapping(source ="modelvcl", target = "modelvclTO")
    @Mapping(source ="serievcl", target = "serievclTO")
    @Mapping(source ="typemoteurvcl", target = "typemoteurvclTO")
    @Mapping(source ="reservoirvcl", target = "reservoirvclTO")
    @Mapping(source ="kmvcl", target = "kmvclTO")
    @Mapping(source ="couleurvcl", target = "couleurvclTO")
    @Mapping(source ="descriptionvcl", target = "descriptionvclTO")
    @Mapping(source ="boitevitessevcl", target = "boitevitessevclTO")
    @Mapping(source ="statutvcl", target = "statutvclTO")
    @Mapping(source ="datemiseligne", target = "datemiseligneTO")
    @Mapping(source ="datedebutdisponibilite", target = "datedebutdisponibiliteTO")
    @Mapping(source ="datefindisponibilite", target = "datefindisponibiliteTO")
    @Mapping(source ="cautionvcl", target = "cautionvclTO")
    @Mapping(source ="prixvcl", target = "prixvclTO")
    @Mapping(source ="compte", target = "compteTO")
    VehiculeTO toDTO(Vehicule d);

    Vehicule toEntity(VehiculeTO d);


}

