package com.projet.AKB.repositories.verificateur;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Verificateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificateurRepository extends JpaRepository<Verificateur, Long> {
    Verificateur findBymailvrf(String email);
}