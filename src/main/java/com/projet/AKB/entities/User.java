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
@Table(name="t_user_usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usr",nullable = false)
    private Long id_usr;

    @Column(name = "nom_usr",nullable = false)
    private String nom_usr;

    @Column(name = "prenom_usr",nullable = false)
    private String prenom_usr;

    @Column(name = "date_naissance",nullable = false)
    private Date date_naissance;

    @Column(name = "adresse_usr",nullable = false)
    private String adresse_usr;

    @Column(name = "code_postale_usr",nullable = false)
    private String code_postale_usr;

    @Column(name = "piece_identite_usr",nullable = false)
    private String piece_identite_usr;

    @Column(name = "sexe_usr",nullable = false)
    private String sexe_usr;



}
