package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.Series;
import com.dea.cricketerwage.Data.Repository.Interfaces.ISeriesRepository;
import com.dea.cricketerwage.Services.Interfaces.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeriesService implements ISeriesService {
    @Autowired
    private ISeriesRepository _iSeriesRepository;

    @Override
    public Iterable<Series> getAllSeries() {

        return _iSeriesRepository.findAll();
    }

    @Override
    public Optional<Series> getSeriesById(int id) {

        return _iSeriesRepository.findById(id);
    }

    @Override
    public Series addSeries(Series series) {
        return _iSeriesRepository.save(series);
    }

    @Override
    public boolean updateSeries(Series series) {
        return false;
    }
}