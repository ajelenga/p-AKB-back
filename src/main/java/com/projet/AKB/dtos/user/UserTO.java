package com.projet.AKB.dtos.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class UserTO {

    private Long idusrTO;


    private String nomusrTO;


    private String prenomusrTO;


    private Date datenaissanceTO;


    private String adresseusrTO;


    private String codepostaleusrTO;


    private String pieceidentiteusrTO;


    private String sexeusrTO;

}
