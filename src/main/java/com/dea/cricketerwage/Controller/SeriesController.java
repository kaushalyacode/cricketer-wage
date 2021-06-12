package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Series;
import com.dea.cricketerwage.Services.Interfaces.ISeriesService;
import com.dea.cricketerwage.ViewModel.SeriesViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("series")
public class SeriesController {
    @Autowired
    private ISeriesService _iSeriesService;
    private ModelMapper modelMapper;

    public SeriesController()
    {
        modelMapper = new ModelMapper();
    }

    @GetMapping("/get")
    public Collection<SeriesViewModel> getAllSeriess()
    {
        var serieses = _iSeriesService.getAllSeries();
        Collection<SeriesViewModel> seriesViewModels = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        serieses.forEach(series -> seriesViewModels.add(mapper.map(series, SeriesViewModel.class)));
        return seriesViewModels;
    }

    @PostMapping("/add")
    public ResponseEntity<SeriesViewModel> AddSeries(@RequestBody SeriesViewModel seriesViewModel)
    {
        Series series = modelMapper.map(seriesViewModel, Series.class);
        var allSeries =  _iSeriesService.addSeries(series);
        SeriesViewModel svm = modelMapper.map(allSeries,SeriesViewModel.class);
        if(allSeries != null)
        {
            return new ResponseEntity<>(svm, HttpStatus.CREATED);
        }else{

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get/{id}")
    public SeriesViewModel getSeriesId(@PathVariable int id)
    {
        var series =_iSeriesService.getSeriesById(id);
        if(series.isPresent()){
        ModelMapper mapper = new ModelMapper();
        SeriesViewModel singleSeries = modelMapper.map(series.get(), SeriesViewModel.class);
        return singleSeries;
        }else{
            return null;
        }
    }
}