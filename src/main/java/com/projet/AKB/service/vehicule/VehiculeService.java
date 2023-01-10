package com.projet.AKB.service.vehicule;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Vehicule;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import java.util.List;
@Service
public interface VehiculeService {

    List<Vehicule> getVehicules();
}
