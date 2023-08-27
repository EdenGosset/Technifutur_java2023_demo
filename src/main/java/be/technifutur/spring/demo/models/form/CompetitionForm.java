package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.Address;
import be.technifutur.spring.demo.models.entity.DistributionMode;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.validation.contraints.BeforeDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Data
@BeforeDate
public class CompetitionForm {

    @NotBlank
    @UniqueElements
    @Size(min = 5, max = 25)
    private String name;

    @NotNull
    private LocalDate inscriptionStart;

    @NotNull
    private LocalDate inscriptionEnd;

    @NotNull
    private LocalDate competitionStart;

    @NotNull
    private LocalDate competitionEnd;

    private double cashPrice;

    private DistributionMode distributionMode;

    private Game gamePlayed;

    @PositiveOrZero
    private double entry;

    @NotNull
    private Address address;





}
