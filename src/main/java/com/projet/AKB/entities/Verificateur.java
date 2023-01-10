package com.projet.AKB.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="t_verificateur_vrf")

public class Verificateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vrf",nullable = false)
    private Long idvrf;

    @Column(name = "mail_vrf")
    private String mailvrf;

    @Column(name = "photo_profil_vrf")
    private String photoprofilvrf;

    @Column(name = "mot_de_passe_vrf")
    private String motdepassevrf;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usr",nullable = false)
    private User user;

}
