package com.projet.AKB.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_reservation_rsv")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rsv",nullable = false)
    private Long id_rsv;

    @Column(name = "numero_reservation_rsv",nullable = false)
    private Long numero_reservation_rsv;

    @Column(name = "date_debut_location_rsv",nullable = false)
    private Date date_debut_location_rsv;

    @Column(name = "date_fin_location_rsv",nullable = false)
    private Date date_fin_location_rsv;

    @Column(name = "caution_rsv",nullable = false)
    private Double caution_rsv;

    @Column(name = "paiement_rsv",nullable = false)
    private Double paiement_rsv;

    @OneToOne
    @JoinColumn(name = "id_vcl",nullable = false)
    private Vehicule vehicule;



}
