package com.dea.cricketerwage.Data.Repository.Interfaces;

import com.dea.cricketerwage.Data.Model.Series;
import org.springframework.data.repository.CrudRepository;

public interface ISeriesRepository extends CrudRepository<Series, Integer> {
}