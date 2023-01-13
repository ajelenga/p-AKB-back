package com.projet.AKB.web.api;

import com.projet.AKB.entities.Administrateur;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.entities.Verificateur;
import com.projet.AKB.repositories.administrateur.AdminRepository;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import com.projet.AKB.repositories.inscription.UserConnexionAndInscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import com.projet.AKB.service.administrateur.AdministrateurService;
import com.projet.AKB.service.inscription.InscriptionServiceImpl;
import com.projet.AKB.service.verificateur.VerificateurService;
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
    UserConnexionAndInscriptionRepository userInscriptionRepository;

    @Autowired
    InscriptionServiceImpl inscriptionService;

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    AdministrateurService administrateurService;

    @Autowired
    VerificateurService verificateurService;


    @PostMapping(value = "/inscriptionUtilisateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Compte compte) throws Exception {
        log.info("Inscritpion start");
        log.info("Ajouter d'un compte ={}", compte);
        String email = compte.getMailcpt();
        if(email !=null && !"".equals(email)){
            String compteObj = inscriptionService.fetchByEmail(email);
            if(compteObj != null){
                ResponseEntity<String> inscriptionEffectué = new ResponseEntity<>("Inscription non effectué", HttpStatus.INTERNAL_SERVER_ERROR);
                return  inscriptionEffectué;
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


    @PostMapping(value = "/AjoutAdministrateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Administrateur administrateur) throws Exception {
        log.info("Ajout start");
        log.info("Ajouter d'un administrateur ={}", administrateur);

        String email = administrateur.getMailadm();
        if(email !=null && !"".equals(email)){
            String compteObj = inscriptionService.fetchByEmail(email);
                if(compteObj != null){
                 ResponseEntity<String> inscriptionEffectué = new ResponseEntity<>("Inscription non effectué adresse email existe déja", HttpStatus.INTERNAL_SERVER_ERROR);
                 return  inscriptionEffectué;
            }
        }
        User u1=new User();
        u1 = administrateur.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Administrateur comp = new Administrateur();

        comp.setMailadm(administrateur.getMailadm());
        comp.setMot_de_passe_adm(administrateur.getMot_de_passe_adm());
        comp.setUser(u1);

        log.info("compte ={}", comp);
        adminRepository.save(comp);


        return new ResponseEntity<String>("Ajout de l'admin a été effectué avec succés", HttpStatus.CREATED);

    }




    @PostMapping(value = "/AjoutVerificateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Verificateur verificateur) throws Exception {
        log.info("Ajout start");
        log.info("Ajouter d'un Verificateur ={}", verificateur);

        String email = verificateur.getMailvrf();
        if(email !=null && !"".equals(email)){
            String compteObj = inscriptionService.fetchByEmail(email);
                if(compteObj != null){
                    ResponseEntity<String> inscriptionEffectué = new ResponseEntity<>("Inscription non effectué adresse email existe déja", HttpStatus.INTERNAL_SERVER_ERROR);
                    return  inscriptionEffectué;

            }

        }
        User u1=new User();
        u1 = verificateur.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Administrateur comp = new Administrateur();

        comp.setMailadm(verificateur.getMailvrf());
        comp.setMot_de_passe_adm(verificateur.getMotdepassevrf());
        comp.setUser(u1);

        log.info("compte ={}", comp);
        adminRepository.save(comp);


        return new ResponseEntity<String>("Ajout de l'admin a été effectué avec succés", HttpStatus.CREATED);

    }
}
