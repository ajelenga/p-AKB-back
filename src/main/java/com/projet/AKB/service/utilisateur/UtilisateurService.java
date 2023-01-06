package com.projet.AKB.service.utilisateur;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {
    List<Compte> getComptes();
}
