package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.Tier;
import com.dea.cricketerwage.Data.Repository.Interfaces.ITierRepository;
import com.dea.cricketerwage.Services.Interfaces.ITierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TierService implements ITierService {

    @Autowired
    private ITierRepository _iTierRepository;

    @Override
    public Iterable<Tier> getAllTieries() {
        return _iTierRepository.findAll();
    }

    @Override
    public Optional<Tier> getTierById(int id) {
        return _iTierRepository.findById(id);
    }

    @Override
    public Tier addTier(Tier tier) {
        return _iTierRepository.save(tier);
    }

    @Override
    public boolean updateTier(Tier tier) {
        return false;
    }
}