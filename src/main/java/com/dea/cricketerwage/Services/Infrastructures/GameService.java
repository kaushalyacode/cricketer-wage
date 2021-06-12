package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.Game;
import com.dea.cricketerwage.Data.Repository.Interfaces.IGameRepository;
import com.dea.cricketerwage.Services.Interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService implements IGameService {

    @Autowired
    private IGameRepository _iGameRepository;

    @Override
    public Iterable<Game> getAllGames() {
        return _iGameRepository.findAll();
    }

    @Override
    public Optional<Game> getGameById(int id) {

        return _iGameRepository.findById(id);
    }

    @Override
    public Game addGame(Game game) {
        return _iGameRepository.save(game);
    }
}