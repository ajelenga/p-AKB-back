package com.projet.AKB.repositories.administrateur;

import com.projet.AKB.entities.Administrateur;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrateur,Long> {
    Administrateur findBymailadm(String email);

    public Administrateur findBymailadmAndMotdepasseadm(String email, String password);
}
