package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.Player;
import com.dea.cricketerwage.Data.Repository.Interfaces.IPlayerRepository;
import com.dea.cricketerwage.Services.Interfaces.IPlayerService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private IPlayerRepository _iPlayerRepository;
    @Override
    public Iterable<Player> getAllPlayers() {
        return _iPlayerRepository.findAll();    }

    @Override
    public Optional<Player> getPlayerById(int id) {
        return _iPlayerRepository.findById(id);
    }

    @Override
    public Player addPlayer(Player player) {
        var playerSingle=_iPlayerRepository.save(player);
        return playerSingle;
    }

    @Override
    public boolean updatePlayer(Player player) {
        return false;
    }
}