package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.Game;

import java.util.Optional;

public interface IGameService {
    public Iterable<Game> getAllGames();
    public Optional<Game> getGameById(int id);
    public Game addGame(Game game);
}