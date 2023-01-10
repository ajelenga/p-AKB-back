package com.projet.AKB.repositories.connexion;

import com.projet.AKB.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnexionRepository extends JpaRepository<Compte,Long> {


    public Compte findBymailcpt(String  mail_cpt);

    public Compte findBymailcptAndMotdepassecpt(String email, String password);

}
