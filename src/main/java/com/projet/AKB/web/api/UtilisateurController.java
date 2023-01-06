package com.projet.AKB.web.api;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {
    private static final Logger log = LoggerFactory.getLogger(UtilisateurController.class);

    private UtilisateurRepository utilisateurRepository;
    public UtilisateurController(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

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







}
