package com.dea.cricketerwage.Data.Repository.Interfaces;

import com.dea.cricketerwage.Data.Model.Game;
import org.springframework.data.repository.CrudRepository;

public interface IGameRepository extends CrudRepository<Game, Integer> {
}