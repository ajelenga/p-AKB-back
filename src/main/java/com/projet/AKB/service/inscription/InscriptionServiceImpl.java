package com.projet.AKB.service.inscription;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.administrateur.AdminRepository;
import com.projet.AKB.repositories.verificateur.VerificateurRepository;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
@Component /*cela veut dire que ce service/class peut être exporter et urilisé */
public class InscriptionServiceImpl implements InscriptionService{

    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
    VerificateurRepository verificateurRepository;

    @Autowired
    AdminRepository administrateurRepository;


    public Compte inscription(Compte compte){
            return inscriptionRepository.save(compte);
        }

        public String fetchByEmail(String email){
            String compte = null;
            String compte2 = null;
            String compte3 = null;
            if(inscriptionRepository.findBymailcpt(email) !=null){
                compte = inscriptionRepository.findBymailcpt(email).getMailcpt();
            }
            if(administrateurRepository.findBymailadm(email) !=null){
                compte2 = administrateurRepository.findBymailadm(email).getMot_de_passe_adm();
            }
            if(verificateurRepository.findBymailvrf(email) !=null){
                compte3= verificateurRepository.findBymailvrf(email).getMailvrf();
            }
          
            if(compte != null){
                return compte;
            } else if (compte2 !=null) {
                return compte2;
            }
            return compte3;
        }
}
