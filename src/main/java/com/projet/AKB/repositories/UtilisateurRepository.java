package com.projet.AKB.repositories;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Compte,Long> {

}
