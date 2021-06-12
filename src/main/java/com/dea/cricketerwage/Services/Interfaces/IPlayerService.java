package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.Player;

import java.util.Optional;

public interface IPlayerService {

    public Iterable<Player> getAllPlayers();
    public Optional<Player> getPlayerById(int id);
    public Player addPlayer(Player player);
    public boolean updatePlayer(Player player);
}