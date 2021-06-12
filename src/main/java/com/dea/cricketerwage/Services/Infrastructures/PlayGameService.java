package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.PlayGame;
import com.dea.cricketerwage.Data.Repository.Interfaces.IPlayGameRepository;
import com.dea.cricketerwage.Services.Interfaces.IPlayGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayGameService implements IPlayGameService {
    @Autowired
    private IPlayGameRepository _iGamePlayRepository;

    @Override
    public Iterable<PlayGame> getAllPlayGame() {
        return _iGamePlayRepository.findAll();
    }

    @Override
    public Optional<PlayGame> getPlayGameById(int id) {
        return _iGamePlayRepository.findById(id);
    }

    @Override
    public PlayGame addPlayGame(PlayGame playGame) {
        return  _iGamePlayRepository.save(playGame);
    }
}
