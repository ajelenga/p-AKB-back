package com.projet.AKB.web.api;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import com.projet.AKB.repositories.inscription.UserInscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import com.projet.AKB.service.utilisateur.UtilisateurServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.awt.*;

@RestController
@CrossOrigin
public class InscriptionController {
    private static final Logger log = LoggerFactory.getLogger(InscriptionController.class);
    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    UserInscriptionRepository userInscriptionRepository;

    @Autowired
    UtilisateurServiceImpl utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @PostMapping(value = "/inscrptionUtilisateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Compte compte){
        log.info("Inscritpion start");
        log.info("Ajouter d'un compte ={}", compte);

        User u1=new User();
        u1 = compte.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Compte comp = new Compte();

        comp.setMail_cpt(compte.getMail_cpt());
        comp.setMot_de_passe_cpt(compte.getMot_de_passe_cpt());

        comp.setUser(u1);

        inscriptionRepository.save(comp);

        return new ResponseEntity<String>("Inscription effectué", HttpStatus.CREATED);

    }
}
