package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.Tier;

import java.util.Optional;

public interface ITierService {
    public Iterable<Tier> getAllTieries();
    public Optional<Tier> getTierById(int id);
    public Tier addTier(Tier tier);
    public boolean updateTier(Tier tier);
}