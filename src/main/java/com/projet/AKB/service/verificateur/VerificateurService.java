package com.projet.AKB.service.verificateur;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Verificateur;
import org.jvnet.hk2.annotations.Service;

@Service
public interface VerificateurService {

    public Verificateur findBymailcpt(String email);

    public Verificateur findBymailcptAndMotdepassecpt(String email, String password);
}
