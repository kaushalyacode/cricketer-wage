package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.PlayGame;
import com.dea.cricketerwage.Data.Model.PlaySeries;
import com.dea.cricketerwage.Data.Repository.Interfaces.IPlayGameRepository;
import com.dea.cricketerwage.Data.Repository.Interfaces.IPlaySeriesRepository;
import com.dea.cricketerwage.Services.Interfaces.IPlaySeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaySeriesService implements IPlaySeriesService {

    @Autowired
    private IPlaySeriesRepository _iSeriesPlayRepository;

    @Override
    public Iterable<PlaySeries> getAllPlaySeries() {
        return _iSeriesPlayRepository.findAll();
    }

    @Override
    public Optional<PlaySeries> getPlaySeriesById(int id) {
        return _iSeriesPlayRepository.findById(id);
    }

    @Override
    public PlaySeries addPlaySeries(PlaySeries playSeries) {
        return  _iSeriesPlayRepository.save(playSeries);
    }
}
