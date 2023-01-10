package com.projet.AKB.dtos.vehicule;


import com.projet.AKB.entities.Compte;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
public class VehiculeTO {

    private Long idvclTO;


    private String marquevclTO;


    private String modelvclTO;


    private String serievclTO;

    private String typemoteurvclTO;


    private String reservoirvclTO;


    private String kmvclTO;


    private String couleurvclTO;


    private String descriptionvclTO;


    private String boitevitessevclTO;


    private String statutvclTO;


    private Date datemiseligneTO;


    private Date datedebutdisponibiliteTO;


    private Date datefindisponibiliteTO;


    private Double cautionvclTO;

    private Double prixvclTO;
    private Compte compteTO;



}

