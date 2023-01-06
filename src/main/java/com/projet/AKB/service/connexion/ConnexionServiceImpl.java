package com.projet.AKB.service.connexion;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import com.projet.AKB.service.utilisateur.UtilisateurService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnexionServiceImpl implements ConnexionService{

    @Autowired
    private ConnexionService connexionRepository;

    @Override
    public List<Compte> getComptes(){
        return connexionRepository.getComptes();
    };
}
