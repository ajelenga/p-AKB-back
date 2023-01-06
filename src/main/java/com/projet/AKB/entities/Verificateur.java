package com.projet.AKB.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_verificateur_vrf")

public class Verificateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vrf",nullable = false)
    private Long id_vrf;

    @Column(name = "mail_vrf")
    private String mail_vrf;

    @Column(name = "photo_profil_vrf")
    private String photo_profil_vrf;

    @Column(name = "mot_de_passe_vrf")
    private String mot_de_passe_vrf;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usr",nullable = false)
    private User user;

}
