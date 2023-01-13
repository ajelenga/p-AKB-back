package com.projet.AKB.service.verificateur;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Verificateur;
import com.projet.AKB.repositories.verificateur.VerificateurRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class VerificateurServiceImpl implements VerificateurService {

    VerificateurRepository verificateurRepository ;
    @Override
    public Verificateur findBymailcpt(String email) {
        return verificateurRepository.findBymailvrf(email);
    }

    @Override
    public Verificateur findBymailcptAndMotdepassecpt(String email, String password) {
        return null;
    }
}
