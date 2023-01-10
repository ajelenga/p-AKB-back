package com.projet.AKB.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_administrateur_adm")

public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adm",nullable = false)
    private Long idadm;

    @Column(name = "mail_adm")
    private String mailadm;

    @Column(name = "photo_profil_adm")
    private String photoprofiladm;

    @Column(name = "mot_de_passe_adm")
    private String mot_de_passe_adm;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usr",nullable = false)
    private User user;

}
