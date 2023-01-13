package com.projet.AKB.dtos.reservation;

import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Vehicule;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ReservationTO {

    private Long idTO;
    private Long numeroReservationTO;
    private Date dateDebutLocationTO;
    private String adressePriseVehiculeTO;
    private Date dateFinLocationTO;
    private Double cautionRsvTO;
    private Double paiementRsvTO;
    private VehiculeTO vehiculeTO;
}
