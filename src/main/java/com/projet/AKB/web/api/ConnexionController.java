package com.projet.AKB.web.api;

import com.projet.AKB.dtos.Login;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ConnexionController {

    private static final Logger log = LoggerFactory.getLogger(ConnexionController.class);
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping(path = "/connexion/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getConnexion(@PathVariable(name="id") String code)throws Exception{
        log.info("Dépenses numéro ={}",code);

            List<Compte> comptes = utilisateurRepository.findAll();
            Compte c = new Compte();
            comptes.forEach(compte -> {
                if(compte.getMot_de_passe_cpt().equals(code)){
                    c.setUser(compte.getUser());
                }
            });
            log.info("Compte = {}",c);
            if(c.getUser()==null){
                return new ResponseEntity<>("pas de connexion", HttpStatus.OK);
            }
            return new ResponseEntity<>("connecté", HttpStatus.OK);

    }


    @GetMapping(path = "/connexion",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getConnexion2(@RequestBody Compte login)throws Exception{
        log.info("Login du user {}",login.getMail_cpt());
        log.info("Mot de passe du user ={}",login.getMail_cpt());
        List<Compte> comptes = utilisateurRepository.findAll();
        Compte c = new Compte();
        comptes.forEach(compte -> {
            if(compte.getMot_de_passe_cpt().equals(login.getMot_de_passe_cpt()) && compte.getMot_de_passe_cpt().equals(login.getMail_cpt()) ){
                c.setUser(compte.getUser());
            }
        });
        log.info("Compte = {}",c);
        if(c.getUser()==null){
            return new ResponseEntity<>("pas de connexion", HttpStatus.OK);
        }
        return new ResponseEntity<>("connecté", HttpStatus.OK);

    }



}
