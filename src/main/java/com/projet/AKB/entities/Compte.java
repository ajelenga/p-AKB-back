package com.projet.AKB.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_compte_cpt")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cpt",nullable = false)
    private Long id_cpt;

    @Column(name = "mail_user_cpt")
    private String mail_cpt;

    @Column(name = "photo_profil_cpt")
    private String photo_profil_cpt;

    @Column(name = "mot_de_passe_cpt")
    private String mot_de_passe_cpt;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usr",nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cpt",nullable = false)
    private List<Reservation> reservation = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cpt",nullable = false)
    private List<Vehicule> vehicules = new ArrayList<>();


}


