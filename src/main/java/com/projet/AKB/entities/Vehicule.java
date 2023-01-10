package com.projet.AKB.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "compte")
@ToString(exclude = "compte")
@Table(name="t_vehicule_vcl")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vcl",nullable = false)
    private Long idvcl;

    @Column(name = "marque_vcl",nullable = false)
    private String marquevcl;

    @Column(name = "model_vcl",nullable = false)
    private String modelvcl;

    @Column(name = "serie_vcl",nullable = false)
    private String serievcl;

    @Column(name = "type_moteur_vcl",nullable = false)
    private String typemoteurvcl;

    @Column(name = "reservoir_vcl",nullable = false)
    private String reservoirvcl;

    @Column(name = "km_vcl",nullable = false)
    private String kmvcl;

    @Column(name = "couleur_vcl",nullable = false)
    private String couleurvcl;

    @Column(name = "description_vcl",nullable = false)
    private String descriptionvcl;

    @Column(name = "boite_vitesse_vcl",nullable = false)
    private String boitevitessevcl;

    @Column(name = "statut_vcl",nullable = false)
    private String statutvcl;

    @Column(name = "date_mise_ligne",nullable = false)
    private Date datemiseligne;

    @Column(name = "date_debut_disponibilite",nullable = false)
    private Date datedebutdisponibilite;

    @Column(name = "date_fin_disponibilite",nullable = false)
    private Date datefindisponibilite;

    @Column(name = "caution_vcl",nullable = false)
    private Double cautionvcl;

    @Column(name = "prix_vcl",nullable = false)
    private Double prixvcl;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cpt",nullable = true)
    private Compte compte;



}
