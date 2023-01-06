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
@Table(name="t_vehicule_vcl")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vcl",nullable = false)
    private Long id_vcl;

    @Column(name = "marque_vcl",nullable = false)
    private String marque_vcl;

    @Column(name = "model_vcl",nullable = false)
    private String model_vcl;

    @Column(name = "serie_vcl",nullable = false)
    private String serie_vcl;

    @Column(name = "type_moteur_vcl",nullable = false)
    private String type_moteur_vcl;

    @Column(name = "reservoir_vcl",nullable = false)
    private String reservoir_vcl;

    @Column(name = "km_vcl",nullable = false)
    private String km_vcl;

    @Column(name = "couleur_vcl",nullable = false)
    private String couleur_vcl;

    @Column(name = "description_vcl",nullable = false)
    private String description_vcl;

    @Column(name = "boite_vitesse_vcl",nullable = false)
    private String boite_vitesse_vcl;

    @Column(name = "statut_vcl",nullable = false)
    private String statut_vcl;

    @Column(name = "date_mise_ligne",nullable = false)
    private Date date_mise_ligne;

    @Column(name = "date_debut_disponibilite",nullable = false)
    private Date date_debut_disponibilite;

    @Column(name = "date_fin_disponibilite",nullable = false)
    private Date date_fin_disponibilite;

    @Column(name = "caution_vcl",nullable = false)
    private Double caution_vcl;

    @Column(name = "prix_vcl",nullable = false)
    private Double prix_vcl;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vcl",nullable = false)
    private Compte compte;



}
