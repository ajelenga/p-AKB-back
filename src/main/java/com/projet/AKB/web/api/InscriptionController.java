package com.projet.AKB.web.api;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import com.projet.AKB.repositories.inscription.UserInscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import com.projet.AKB.service.inscription.InscriptionServiceImpl;
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

@RestController
@CrossOrigin
public class InscriptionController {
    private static final Logger log = LoggerFactory.getLogger(InscriptionController.class);
    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    UserInscriptionRepository userInscriptionRepository;

    @Autowired
    InscriptionServiceImpl inscriptionService;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @PostMapping(value = "/inscriptionUtilisateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Compte compte) throws Exception {
        log.info("Inscritpion start");
        log.info("Ajouter d'un compte ={}", compte);

        String email = compte.getMailcpt();
        if(email !=null && !"".equals(email)){
            Compte compteObj = inscriptionService.fetchByEmail(email);
            if(compteObj != null){
                throw new Exception("this user with email exist in data base");
            }
        }
        User u1=new User();
        u1 = compte.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Compte comp = new Compte();

        comp.setMailcpt(compte.getMailcpt());
        comp.setMotdepassecpt(compte.getMotdepassecpt());
        comp.setUser(u1);

        log.info("compte ={}", comp);
        inscriptionRepository.save(comp);

        return new ResponseEntity<String>("Inscription effectué", HttpStatus.CREATED);

    }
}
