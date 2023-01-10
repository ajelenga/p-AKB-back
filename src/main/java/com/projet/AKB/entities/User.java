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
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="t_user_usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usr",nullable = false)
    private Long idusr;

    @Column(name = "nom_usr",nullable = false)
    private String nomusr;

    @Column(name = "prenom_usr",nullable = false)
    private String prenomusr;

    @Column(name = "date_naissance",nullable = false)
    private Date datenaissance;

    @Column(name = "adresse_usr",nullable = false)
    private String adresseusr;

    @Column(name = "code_postale_usr",nullable = false)
    private String codepostaleusr;

    @Column(name = "piece_identite_usr",nullable = false)
    private String pieceidentiteusr;

    @Column(name = "sexe_usr",nullable = false)
    private String sexeusr;



}
