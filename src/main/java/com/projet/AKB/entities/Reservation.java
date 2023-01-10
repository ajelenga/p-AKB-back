package com.projet.AKB.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name="t_reservation_rsv")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rsv",nullable = false)
    private Long idrsv;

    @Column(name = "numero_reservation_rsv",nullable = false)
    private Long numeroreservationrsv;

    @Column(name = "date_debut_location_rsv",nullable = false)
    private Date datedebutlocationrsv;

    @Column(name = "date_fin_location_rsv",nullable = false)
    private Date datefinlocationrsv;

    @Column(name = "caution_rsv",nullable = false)
    private Double cautionrsv;

    @Column(name = "paiement_rsv",nullable = false)
    private Double paiementrsv;

    @OneToOne
    @JoinColumn(name = "id_vcl",nullable = false)
    private Vehicule vehicule;



}
