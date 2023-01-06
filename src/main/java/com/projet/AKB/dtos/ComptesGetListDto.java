package com.projet.AKB.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class ComptesGetListDto {
    private List<CompteGetDto> compteGetDtos = new ArrayList<>();
}
