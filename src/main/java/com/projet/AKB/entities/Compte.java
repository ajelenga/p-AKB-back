package com.projet.AKB.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_compte_cpt")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cpt",nullable = false)
    private Long idcpt;

    @Column(name = "mail_user_cpt")
    private String mailcpt;

    @Column(name = "photo_profil_cpt")
    private String photoprofilcpt;

    @Column(name = "mot_de_passe_cpt")
    private String motdepassecpt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usr",nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cpt",nullable = true)
    private List<Reservation> reservation = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cpt",nullable = true)
    private List<Vehicule> vehicules = new ArrayList<>();


}


