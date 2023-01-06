package com.projet.AKB.service.connexion;

import com.projet.AKB.entities.Compte;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface ConnexionService {

    List<Compte> getComptes();
}
