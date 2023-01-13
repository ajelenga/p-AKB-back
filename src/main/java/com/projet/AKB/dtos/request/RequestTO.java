package com.projet.AKB.dtos.request;

import lombok.Data;

import java.util.Date;

@Data
public class RequestTO {
    private String dateDebut;

    private String dateFin;

    private String addressePrise;
}
