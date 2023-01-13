package com.projet.AKB.dtos.reservation;

import com.projet.AKB.dtos.compte.CompteTO;
import com.projet.AKB.dtos.vehicule.VehiculeMapperImpl;
import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Reservation;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class reservationMapImpl {

    @Autowired
    VehiculeMapperImpl vehiculeMapper;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public ReservationTO toDTO(Reservation d) {
        if ( d == null ) {
            return null;
        }

        ReservationTO reservationTO = new ReservationTO();

        reservationTO.setNumeroReservationTO( d.getNumeroreservationrsv() );
        reservationTO.setDateDebutLocationTO( d.getDatedebutlocationrsv() );
        reservationTO.setAdressePriseVehiculeTO( d.getAdressePriseVehicule() );
        reservationTO.setDateFinLocationTO( d.getDatefinlocationrsv() );
        reservationTO.setCautionRsvTO( d.getCautionrsv() );
        reservationTO.setPaiementRsvTO( d.getPaiementrsv() );
        VehiculeTO v ;
        v = this.vehiculeMapper.toDTO(d.getVehicule());
        reservationTO.setVehiculeTO(v);
        return reservationTO;
}
}
