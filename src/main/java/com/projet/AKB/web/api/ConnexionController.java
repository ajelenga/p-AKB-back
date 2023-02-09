package com.projet.AKB.web.api;

import com.projet.AKB.dtos.StatutConnexion;
import com.projet.AKB.dtos.login.LoginTO;
import com.projet.AKB.entities.Administrateur;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.entities.Verificateur;
import com.projet.AKB.repositories.administrateur.AdminRepository;
import com.projet.AKB.repositories.connexion.ConnexionRepository;
import com.projet.AKB.repositories.inscription.UserConnexionAndInscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import com.projet.AKB.repositories.verificateur.VerificateurRepository;
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

    @Autowired
    private UserConnexionAndInscriptionRepository userConnexionAndInscriptionRepository;
    @Autowired
    private VerificateurRepository verificateurRepository;
    @Autowired
    private AdminRepository adminRepository;



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

    @PostMapping(path = "/connexionUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatutConnexion> getConnexion2(@RequestBody LoginTO login) throws Exception {
        log.info("c{}", login.email);
        log.info("Login du user {}", login.getLogin());
        log.info("Mot de passe du user ={}", login.getMot_de_pass());
        StatutConnexion response = new StatutConnexion();
        Compte c =connexionRepository.findBymailcptAndMotdepassecpt(login.getEmail(),login.getMot_de_pass());
        Verificateur v =verificateurRepository.findBymailvrfAndMotdepassevrf(login.getEmail(),login.getMot_de_pass());
        Administrateur a =adminRepository.findBymailadmAndMotdepasseadm(login.getEmail(),login.getMot_de_pass());

        if (c == null && v==null && a==null) {
            response.setStatutTO("Pas de connexion");
            response.setStatutTO("");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if(c!=null){
            response.setStatutTO("user");
            log.info("Compte = {}", c);
            User u =userConnexionAndInscriptionRepository.getById(c.getUser().getIdusr());
            response.setMailcptTO(c.getMailcpt());
            response.setPrenomusrTO(u.getPrenomusr());
            response.setNomusrTO(u.getNomusr());
            response.setReponseTO(HttpStatus.OK);
        }
        if (a!=null) {
            response.setStatutTO("admin");
            log.info("admin = {}", a);
            User u =userConnexionAndInscriptionRepository.getById(a.getUser().getIdusr());
            response.setMailcptTO(a.getMailadm());
            response.setPrenomusrTO(u.getPrenomusr());
            response.setNomusrTO(u.getNomusr());
            response.setReponseTO(HttpStatus.OK);
        }
        if(v!=null){
            response.setStatutTO("verificateur");
            log.info("verif = {}", v);
            User u =userConnexionAndInscriptionRepository.getById(v.getUser().getIdusr());
            response.setMailcptTO(v.getMailvrf());
            response.setPrenomusrTO(u.getPrenomusr());
            response.setNomusrTO(u.getNomusr());
            response.setReponseTO(HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
