package com.projet.AKB.web.api;

import com.projet.AKB.dtos.StatutConnexion;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Reservation;
import com.projet.AKB.entities.Vehicule;
import com.projet.AKB.repositories.connexion.ConnexionRepository;
import com.projet.AKB.repositories.inscription.UserConnexionAndInscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;
/* Class pour faire les test */
@RestController
@CrossOrigin
public class UtilisateurController {
    private static final Logger log = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UserConnexionAndInscriptionRepository userRepository;

    @Autowired
    private ConnexionRepository connexionRepository;


    @GetMapping(path = "/comptes",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Compte>> depenseList(){
        List<Compte> l = new ArrayList<>();
        List<Compte> comptes = utilisateurRepository.findAll();
        comptes.forEach(compte -> {
            Compte c= new Compte();
            c.setUser(compte.getUser());
            c.setReservation(compte.getReservation());

            l.add(c);
        });

        return new ResponseEntity<>(l, HttpStatus.OK);

    }

    @DeleteMapping(path="/delCompte", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatutConnexion> deleteCompte(@RequestBody Compte compte){
        StatutConnexion response = new StatutConnexion();
        log.info("Suppression du compte start{} ++++++++++++++++++++",compte);
        response.setStatutTO("compte n'existe pas");
        Compte c = connexionRepository.findBymailcpt(compte.getMailcpt());
        if(c == null){
            return  new ResponseEntity<StatutConnexion>(response, HttpStatus.OK);
        }
        response.setStatutTO("compte attaché à l'email "+compte.getMailcpt() +" est supprimé  ");
        response.setCommentaireTO("commentaireSupprime");
        utilisateurRepository.deleteById(c.getIdcpt());
        userRepository.deleteById(c.getUser().getIdusr());
        return  new ResponseEntity<StatutConnexion>(response, HttpStatus.OK);
    }




}
