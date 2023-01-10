package com.projet.AKB.service.vehicule;

import com.projet.AKB.entities.Vehicule;
import com.projet.AKB.repositories.vehicule.VehiculeRepository;
import com.projet.AKB.service.utilisateur.UtilisateurService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class VehiculeServiceImpl implements VehiculeService{

    @Autowired
    VehiculeRepository vehiculeRepository;
    @Override
    public List<Vehicule> getVehicules() {
        return vehiculeRepository.findAll();
    }
}
