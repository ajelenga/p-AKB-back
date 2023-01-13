package com.projet.AKB.repositories.inscription;

import com.projet.AKB.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConnexionAndInscriptionRepository extends JpaRepository<User,Long> {
}
