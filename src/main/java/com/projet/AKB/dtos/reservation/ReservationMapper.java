package com.projet.AKB.dtos.reservation;

import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Reservation;
import com.projet.AKB.entities.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source ="idrsv", target = "idTO", ignore = true)
    @Mapping(source ="numeroreservationrsv", target = "numeroReservationTO")
    @Mapping(source ="datedebutlocationrsv", target = "dateDebutLocationTO")
    @Mapping(source ="adressePriseVehicule", target = "adressePriseVehiculeTO")
    @Mapping(source ="datefinlocationrsv", target = "dateFinLocationTO")
    @Mapping(source ="cautionrsv", target = "cautionRsvTO")
    @Mapping(source ="paiementrsv", target = "paiementRsvTO")
    @Mapping(source ="vehicule", target = "vehiculeTO")
    ReservationTO toDTO(Reservation d);

//    Reservation toEntity(ReservationTO d);

}
