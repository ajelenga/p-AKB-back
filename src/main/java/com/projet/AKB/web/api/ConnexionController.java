package com.projet.AKB.web.api;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.connexion.ConnexionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ConnexionController {

    private static final Logger log = LoggerFactory.getLogger(ConnexionController.class);
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ConnexionRepository connexionRepository;

/*    @GetMapping(path = "/connexion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getConnexion(@PathVariable(name = "id") String code) throws Exception {
        log.info("connexion numéro ={}", code);


        List<Compte> comptes = utilisateurRepository.findAll();
        Compte c = new Compte();
        comptes.forEach(compte -> {
            if (compte.getMotdepassecpt().equals(code)) {
                c.setUser(compte.getUser());
            }
        });
        log.info("Compte = {}", c);
        if (c.getUser() == null) {
            return new ResponseEntity<>("pas de connexion", HttpStatus.OK);
        }
        return new ResponseEntity<>("connecté", HttpStatus.OK);

    }*/

    @GetMapping(path = "/connexion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getConnexion2(@RequestBody Compte login) throws Exception {
        log.info("Login du user {}", login.getMailcpt());
        log.info("Mot de passe du user ={}", login.getMailcpt());

        Compte c =connexionRepository.findBymailcptAndMotdepassecpt(login.getMailcpt(),login.getMotdepassecpt());
        log.info("Compte = {}", c);
        if (c == null) {
            return new ResponseEntity<>("pas de connexion", HttpStatus.OK);
        }
        return new ResponseEntity<>("connecté", HttpStatus.OK);

    }



}
