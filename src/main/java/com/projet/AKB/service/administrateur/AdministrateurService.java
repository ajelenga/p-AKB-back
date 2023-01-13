package com.projet.AKB.service.administrateur;

import com.projet.AKB.entities.Administrateur;
import com.projet.AKB.entities.Compte;
import org.jvnet.hk2.annotations.Service;

@Service
public interface AdministrateurService {

    public Administrateur findBymailcpt(String email);

    public Administrateur findBymailcptAndMotdepassecpt(String email, String password);
}
