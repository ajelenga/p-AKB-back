package com.projet.AKB.web.api;

import com.projet.AKB.dtos.StatutConnexion;
import com.projet.AKB.entities.Administrateur;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.entities.Verificateur;
import com.projet.AKB.repositories.administrateur.AdminRepository;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import com.projet.AKB.repositories.inscription.UserConnexionAndInscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import com.projet.AKB.repositories.verificateur.VerificateurRepository;
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

import java.util.Date;

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
    VerificateurRepository verificateurRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    AdministrateurService administrateurService;

    @Autowired
    VerificateurService verificateurService;


    @PostMapping(value = "/inscriptionUtilisateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatutConnexion> save(@RequestBody Compte compte) throws Exception {
        log.info("Inscritpion start");
        log.info("Ajouter d'un compte ={}", compte);
        StatutConnexion response = new StatutConnexion();
        String email = compte.getMailcpt();
        if(email !=null && !"".equals(email)){
            String compteObj = inscriptionService.fetchByEmail(email);
            if(compteObj != null){
                response.setStatutTO("Inscription non effectué");
                response.setCommentaireTO("adesse email " + compte.getMailcpt()+ " existe déja");
                ResponseEntity<StatutConnexion> inscriptionEffectué = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                return  inscriptionEffectué;
            }
        }

        User u1=new User();
        response.setStatutTO("Inscription utilisateur effectué");
        u1 = compte.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Compte comp = new Compte();
        comp.setMailcpt(compte.getMailcpt());
        comp.setMotdepassecpt(compte.getMotdepassecpt());
        comp.setUser(u1);
        log.info("compte ={}", comp);
        inscriptionRepository.save(comp);
        return new ResponseEntity<StatutConnexion>(response, HttpStatus.CREATED);

    }



    @PostMapping(value = "/AjoutAdministrateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatutConnexion> save(@RequestBody Administrateur administrateur) throws Exception {
        log.info("Ajout start");
        log.info("Ajouter d'un administrateur ={}", administrateur);
        StatutConnexion response = new StatutConnexion();
        String email = administrateur.getMailadm();
        if(email !=null && !"".equals(email)){
            String compteObj = inscriptionService.fetchByEmail(email);
                if(compteObj != null){
                    response.setStatutTO("Inscription non effectué");
                    response.setCommentaireTO("adesse email " + administrateur.getMailadm()+ " existe déja");
                    ResponseEntity<StatutConnexion> inscriptionEffectué = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                    return  inscriptionEffectué;

            }
        }
        User u1=new User();
        response.setStatutTO("Inscription admin effectué");
        u1 = administrateur.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Administrateur comp = new Administrateur();

        comp.setMailadm(administrateur.getMailadm());
        comp.setMotdepasseadm(administrateur.getMotdepasseadm());
        comp.setUser(u1);

        log.info("compte ={}", comp);
        adminRepository.save(comp);


        return new ResponseEntity<StatutConnexion>(response, HttpStatus.CREATED);

    }




    @PostMapping(value = "/AjoutVerificateur", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatutConnexion> save(@RequestBody Verificateur verificateur) throws Exception {
        log.info("Ajout start");
        log.info("Ajouter d'un Verificateur ={}", verificateur);
        StatutConnexion response = new StatutConnexion();
        String email = verificateur.getMailvrf();
        if(email !=null && !"".equals(email)){
            String compteObj = inscriptionService.fetchByEmail(email);
                if(compteObj != null){
                    response.setStatutTO("Inscription non effectué");
                    response.setCommentaireTO("adesse email " + verificateur.getMailvrf()+ " existe déja");
                    ResponseEntity<StatutConnexion> inscriptionEffectué = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                    return  inscriptionEffectué;

            }

        }
        User u1=new User();
        response.setStatutTO("Inscription verificateur effectué");
        u1 = verificateur.getUser();
        log.info("USER ={}", u1);
        userInscriptionRepository.save(u1);
        Verificateur comp = new Verificateur();

        comp.setMailvrf(verificateur.getMailvrf());
        comp.setMotdepassevrf(verificateur.getMotdepassevrf());
        comp.setUser(u1);

        log.info("compte ={}", comp);
        verificateurRepository.save(comp);


        return new ResponseEntity<StatutConnexion>(response, HttpStatus.CREATED);

    }
}
