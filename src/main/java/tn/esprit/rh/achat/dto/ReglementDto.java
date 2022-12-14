package tn.esprit.rh.achat.dto;

import lombok.Builder;
import lombok.Data;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.exceptions.InvalidEntityException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ReglementDto {
    private Long idReglement;
    private Float montantPaye;
    private Float montantRestant;
    private Boolean payee;
    private Date dateReglement;

    public static Reglement toEntity(ReglementDto dto){
        if(dto==null){
            throw new InvalidEntityException("données entrées invalide");
        }
        return Reglement
                .builder()
                .idReglement(dto.idReglement)
                .dateReglement(dto.dateReglement)
                .montantPaye(dto.montantPaye)
                .montantRestant(dto.montantRestant)
                .payee(dto.payee)
                .build();
    }

    public static ReglementDto toDto(Reglement reglement){
        if(reglement==null){
            throw new InvalidEntityException("données entrées invalide");
        }
        return ReglementDto
                .builder()
                .idReglement(reglement.getIdReglement())
                .dateReglement(reglement.getDateReglement())
                .montantPaye(reglement.getMontantPaye())
                .montantRestant(reglement.getMontantRestant())
                .payee(reglement.getPayee())
                .build();
    }
    public static List<ReglementDto> toListOfDto(List<Reglement> reglements){
        List<ReglementDto> reglementDtos = new ArrayList<>();
        reglements.forEach(reglement -> reglementDtos.add(ReglementDto.toDto(reglement)));
        return reglementDtos;
    }

    public static List<Reglement> toListOfEntity(List<ReglementDto> reglementDtos){
        List<Reglement> reglements = new ArrayList<>();
        reglementDtos.forEach(reglementDto -> reglements.add(ReglementDto.toEntity(reglementDto)));
        return reglements;
    }
}
