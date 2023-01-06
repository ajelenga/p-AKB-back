package com.projet.AKB.service.utilisateur;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import com.projet.AKB.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<Compte> getComptes(){
        return utilisateurRepository.findAll();
    }
}
