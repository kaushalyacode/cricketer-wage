package com.dea.cricketerwage.Data.Repository.Interfaces;

import com.dea.cricketerwage.Data.Model.Game;
import com.dea.cricketerwage.Data.Model.PlayGame;
import org.springframework.data.repository.CrudRepository;

public interface IPlayGameRepository extends CrudRepository<PlayGame, Integer> {
}
