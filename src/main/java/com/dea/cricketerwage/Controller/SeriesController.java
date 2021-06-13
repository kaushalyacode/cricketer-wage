package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.PlaySeries;
import com.dea.cricketerwage.Data.Model.Series;
import com.dea.cricketerwage.Services.Interfaces.IPlaySeriesService;
import com.dea.cricketerwage.Services.Interfaces.IPlayerService;
import com.dea.cricketerwage.Services.Interfaces.ISeriesService;
import com.dea.cricketerwage.ViewModel.SeriesGetViewModel;
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
    @Autowired
    private IPlaySeriesService _iPlayerSeriesService;
    @Autowired
    private IPlayerService _iPlayerService;


    private ModelMapper modelMapper;

    public SeriesController()
    {
        modelMapper = new ModelMapper();
    }

    @GetMapping("/get")
    public Collection<SeriesGetViewModel> getAllSeriess()
    {
        var serieses = _iSeriesService.getAllSeries();
        Collection<SeriesGetViewModel> seriesViewModels = new ArrayList<>();
        Collection<Integer> pid=new ArrayList<>();
        for (Series series:serieses) {
            var singleSeriesModel = new SeriesGetViewModel();
            singleSeriesModel.setId(series.getId());
            singleSeriesModel.setPrize(series.getPrize());
            singleSeriesModel.setName(series.getName());
            for (PlaySeries ps:series.getPlayerSeries())
            {
                if(ps.isManOfSeries()==true)
                {
                    singleSeriesModel.setPlayerOfSeries(ps.getPlayer().getId());
                }
                pid.add(ps.getPlayer().getId());
            }
            seriesViewModels.add(singleSeriesModel);
        }
        return seriesViewModels;
    }

    @PostMapping("/add")
    public ResponseEntity<SeriesViewModel> AddSeries(@RequestBody SeriesViewModel seriesViewModel)
    {
        Series series = modelMapper.map(seriesViewModel, Series.class);
        var allSeries =  _iSeriesService.addSeries(series);
        SeriesViewModel svm = modelMapper.map(allSeries,SeriesViewModel.class);
        Collection<Integer> pid= new ArrayList<>();

        for (int id:seriesViewModel.getPlayer_id())
        {
            var playSeries = new PlaySeries();
            var player = _iPlayerService.getPlayerById(id).get();
            if(player!=null)
            {
                pid.add(player.getId());
                playSeries.setSeries(allSeries);
                playSeries.setPlayer(player);
                if(player.getId() == seriesViewModel.getPlayerOfSeries()){
                playSeries.setManOfSeries(true);
                svm.setPlayerOfSeries(player.getId());
                }
            }
            _iPlayerSeriesService.addPlaySeries(playSeries);
        }
        svm.setPlayer_id(pid);
        if(allSeries != null)
        {
            return new ResponseEntity<>(svm, HttpStatus.CREATED);
        }else{

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get/{id}")
    public SeriesGetViewModel getSeriesId(@PathVariable int id)
    {
        var series =_iSeriesService.getSeriesById(id);
        if(series.isPresent()){
        ModelMapper mapper = new ModelMapper();
        SeriesGetViewModel singleSeries = modelMapper.map(series.get(), SeriesGetViewModel.class);
        return singleSeries;
        }else{
            return null;
        }
    }
}