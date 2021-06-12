package com.dea.cricketerwage.Data.Repository.Interfaces;

import com.dea.cricketerwage.Data.Model.Player;
import org.springframework.data.repository.CrudRepository;

public interface IPlayerRepository extends CrudRepository<Player, Integer> {
}