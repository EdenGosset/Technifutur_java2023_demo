package be.technifutur.spring.demo.models.dto;

import be.technifutur.spring.demo.models.entity.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data @Builder
public class CompetitionDTO {

    private Long id;
    private String name;
    private LocalDate inscriptionStart;
    private LocalDate inscriptionEnd;
    private LocalDate competitionStart;
    private LocalDate competitionEnd;
    private double entry;
    private double cashPrice;
    private DistributionMode distributionMode;
    private Address address;
    private Game gamePlayed;
    private Set<SmallParticipationDTO> participations;

    public static CompetitionDTO toDTO(Competition entity){
        if (entity == null)
            return null;

        return CompetitionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .inscriptionStart(entity.getInscriptionStart())
                .inscriptionEnd(entity.getInscriptionEnd())
                .competitionStart(entity.getCompetitionStart())
                .competitionEnd(entity.getCompetitionEnd())
                .entry(entity.getEntry())
                .cashPrice(entity.getCashPrice())
                .distributionMode(entity.getDistributionMode())
                .address(entity.getAddress())
                .gamePlayed(entity.getGamePlayed())
                .participations(entity.getParticipations().stream()
                        .map( SmallParticipationDTO::toDTO )
                        .collect(Collectors.toSet()))
                .build();
    }


}
