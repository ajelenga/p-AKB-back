package com.projet.AKB.service.inscription;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component /*cela veut dire que ce service/class peut être exporter et urilisé */
public class InscriptionServiceImpl implements InscriptionService{


    InscriptionRepository inscriptionRepository;


        public Compte inscription(Compte compte){
            return inscriptionRepository.save(compte);
        }

        public Compte fetchByEmail(String email){
            Compte compte = inscriptionRepository.findBymailcpt(email);
            return compte;
        }
}
