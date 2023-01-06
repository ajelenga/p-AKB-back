package com.projet.AKB.repositories.connexion;

import com.projet.AKB.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnexionRepository extends JpaRepository<Compte,Long> {
}
