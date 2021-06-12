package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Game;
import com.dea.cricketerwage.Data.Model.Series;
import com.dea.cricketerwage.Services.Interfaces.IGameService;
import com.dea.cricketerwage.Services.Interfaces.ISeriesService;
import com.dea.cricketerwage.ViewModel.GameFullViewModel;
import com.dea.cricketerwage.ViewModel.GameViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("game")
public class GameController {
    @Autowired
    private IGameService _iGameService;
    @Autowired
    private ISeriesService _iSeriesService;
    private ModelMapper modelMapper;

    public GameController()
    {
        modelMapper = new ModelMapper();
    }

    @PostMapping("/add")
    public ResponseEntity<GameViewModel> AddGame(@RequestBody GameViewModel gameViewModel){

            Game game = modelMapper.map(gameViewModel, Game.class);
            if (getSeriesDetails(gameViewModel.getSeries_id()).equals(null))
            {
              return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }else{
                game.setSeries(getSeriesDetails(gameViewModel.getSeries_id()));
            var singleGame =_iGameService.addGame(game);
            if (singleGame != null)
            {
                var gm= modelMapper.map(singleGame,GameViewModel.class);
                gm.setSeries_id(gameViewModel.getSeries_id());
                return new ResponseEntity<>(gm, HttpStatus.CREATED);
            }
            else {
               return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping("/get")
    public Collection<GameFullViewModel> getAllGame()
    {
        var games = _iGameService.getAllGames();
        Collection<GameFullViewModel> gameViewModels = new ArrayList<>();
        games.forEach(game -> gameViewModels.add(modelMapper.map(game, GameFullViewModel.class)));
        return gameViewModels;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GameViewModel> getGameById(@PathVariable int id)
    {
        var game = _iGameService.getGameById(id);
        if(game.isPresent()){
        GameViewModel singleGame = modelMapper.map(game.get(), GameViewModel.class);

        return new ResponseEntity<>(singleGame,HttpStatus.CREATED);

        }else {
                return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
    }

    private Series getSeriesDetails(int series_id)
    {
        var series = _iSeriesService.getSeriesById(series_id);
        if(series.isPresent())
        {
           return series.get();
        }else{
           return null;
        }
      }
}