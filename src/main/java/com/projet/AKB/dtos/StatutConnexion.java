package com.projet.AKB.dtos;

import com.projet.AKB.dtos.user.UserTO;
import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Reservation;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
public class StatutConnexion {
    private String mailcptTO;

    private String mdpTO;
    private String nomusrTO;
    private String prenomusrTO;
    private String genreTO;
    private String statutTO;

    private String commentaireTO;

    private HttpStatus reponseTO;
}
