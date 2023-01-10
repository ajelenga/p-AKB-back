package com.projet.AKB.repositories.inscription;

import com.projet.AKB.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InscriptionRepository extends JpaRepository<Compte,Long> {

    public Compte findBymailcpt(String email);

    public Compte findBymailcptAndMotdepassecpt(String email, String password);
}