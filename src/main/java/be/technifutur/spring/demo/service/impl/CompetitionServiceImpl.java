package be.technifutur.spring.demo.service.impl;

import be.technifutur.spring.demo.exceptions.ResourceNotFoundException;
import be.technifutur.spring.demo.models.entity.Competition;
import be.technifutur.spring.demo.repository.AddressRepository;
import be.technifutur.spring.demo.repository.CompetitionRepository;
import be.technifutur.spring.demo.service.CompetitionService;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final AddressRepository addressRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, AddressRepository addressRepository) {
        this.competitionRepository = competitionRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Long add(Competition competition) {
        competition.setId(null);

        return competitionRepository.save(competition).getId();

    }

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll().stream()
                .toList();
    }

    @Override
    public Competition getOne(Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(id, Competition.class)
                );
    }

    @Override
    public void update(Long id, Competition competition) {
        Competition entity = getOne(id);

        entity.setName(competition.getName());
        entity.setInscriptionStart(competition.getInscriptionStart());
        entity.setInscriptionEnd(competition.getInscriptionEnd());
        entity.setCompetitionStart(competition.getCompetitionStart());
        entity.setCompetitionEnd(competition.getCompetitionEnd());
        entity.setAddress(competition.getAddress());
        entity.setEntry(competition.getEntry());
        entity.setCashPrice(competition.getCashPrice());
        entity.setGamePlayed(competition.getGamePlayed());
        entity.setDistributionMode(competition.getDistributionMode());

        competitionRepository.save(entity);

    }

    @Override
    public void delete(Long id) {

    }
}
