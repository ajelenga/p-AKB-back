package com.projet.AKB.repositories.inscription;

import com.projet.AKB.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Compte,Long> {
}
