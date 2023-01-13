package com.projet.AKB.dtos.compte;

import com.projet.AKB.dtos.user.UserTO;
import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Reservation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompteTO {

    private Long idcptTO;
    private String mailcptTO;
    private String photoprofilcptTO;
    private String motdepassecptTO;
    private UserTO userTO;
    private List<Reservation> reservationsTO = new ArrayList<>();
    private List<VehiculeTO> vehiculesTO = new ArrayList<>();

}
