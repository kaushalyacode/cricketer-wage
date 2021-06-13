package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.PlayGame;
import com.dea.cricketerwage.Data.Model.PlaySeries;

import java.util.Optional;

public interface IPlaySeriesService {
    public Iterable<PlaySeries> getAllPlaySeries();
    public Optional<PlaySeries> getPlaySeriesById(int id);
    public PlaySeries addPlaySeries(PlaySeries playSeries);
}
