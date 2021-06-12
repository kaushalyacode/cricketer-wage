package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.Series;

import java.util.Optional;

public interface ISeriesService
{
    public Iterable<Series> getAllSeries();
    public Optional<Series> getSeriesById(int id);
    public Series addSeries(Series series);
    public boolean updateSeries(Series series);
}