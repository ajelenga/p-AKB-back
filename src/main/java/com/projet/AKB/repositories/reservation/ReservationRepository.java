package com.projet.AKB.repositories.reservation;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation ,Long> {

    @Query(value = "SELECT * FROM `t_vehicule_vcl` LEFT JOIN t_reservation_rsv `t_reservation_rsv` on t_reservation_rsv.id_vcl = t_vehicule_vcl.id_vcl  WHERE `adresse_prise_vehicule_rsv` LIKE :addressePrise AND `statut_vcl` LIKE 'à louer' AND  `date_debut_disponibilite` >= :dateDebut", nativeQuery = true)
    List<Reservation> findReservation(@Param("dateDebut") String dateDebut, @Param("addressePrise") String addressePrise);

    /*  @Query(value = "SELECT * FROM `t_vehicule_vcl` LEFT JOIN t_reservation_rsv `t_reservation_rsv` on t_reservation_rsv.id_vcl = t_vehicule_vcl.id_vcl  WHERE `adresse_prise_vehicule_rsv` LIKE :addressePrise AND `statut_vcl` LIKE 'à louer' AND  `date_debut_disponibilite` >= :dateDebut AND `date_fin_disponibilite` >= :dateFin", nativeQuery = true) requête pas fiable à 100%
    * List<Reservation> findReservation(@Param("dateDebut") String dateDebut, @Param("dateFin") String dateFin, @Param("addressePrise") String addressePrise);*/
}
