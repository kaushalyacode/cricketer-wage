package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.PlayGame;

import java.util.Optional;

public interface IPlayGameService
{
    public Iterable<PlayGame> getAllPlayGame();
    public Optional<PlayGame> getPlayGameById(int id);
    public PlayGame addPlayGame(PlayGame playGame);
}
