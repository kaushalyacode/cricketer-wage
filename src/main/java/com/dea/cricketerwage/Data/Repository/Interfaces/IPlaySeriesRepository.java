package com.dea.cricketerwage.Data.Repository.Interfaces;

import com.dea.cricketerwage.Data.Model.PlayGame;
import com.dea.cricketerwage.Data.Model.PlaySeries;
import org.springframework.data.repository.CrudRepository;

public interface IPlaySeriesRepository extends CrudRepository<PlaySeries, Integer> {
}
