package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Game;
import com.dea.cricketerwage.Data.Model.PlayGame;
import com.dea.cricketerwage.Data.Model.Series;
import com.dea.cricketerwage.Services.Interfaces.IGameService;
import com.dea.cricketerwage.Services.Interfaces.IPlayGameService;
import com.dea.cricketerwage.Services.Interfaces.IPlayerService;
import com.dea.cricketerwage.Services.Interfaces.ISeriesService;
import com.dea.cricketerwage.ViewModel.GameFullViewModel;
import com.dea.cricketerwage.ViewModel.GameViewModel;
import com.dea.cricketerwage.ViewModel.PlayerViewModel;
import com.dea.cricketerwage.ViewModel.SeriesViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("game")
public class GameController {
    @Autowired
    private IGameService _iGameService;
    @Autowired
    private ISeriesService _iSeriesService;
    @Autowired
    private IPlayerService _iPlayerService;
    @Autowired
    private IPlayGameService _iPlaGameService;

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
                for (int id:gameViewModel.getPlayer_id())
                {
                      var playGame =new PlayGame();
                      var singlePlayer = _iPlayerService.getPlayerById(id).get();
                      playGame.setGame(singleGame);
                      playGame.setPlayer(singlePlayer);
                      _iPlaGameService.addPlayGame(playGame);
                }
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
        Set<PlayerViewModel> p =new HashSet<>();
        Collection<GameFullViewModel> gameViewModels = new ArrayList<>();
        var allPlayGame =_iPlaGameService.getAllPlayGame();

        for (Game g :games)
        {
            var gfm = new GameFullViewModel();
            gfm.setId(g.getId());
            gfm.setName(g.getName());
            gfm.setDefeate(g.isDefeate());
            gfm.setDraw(g.isDraw());
            gfm.setSeries(modelMapper.map(g.getSeries(), SeriesViewModel.class));
            gfm.setWin(g.isWin());
            for (PlayGame pg:allPlayGame) {
                if(pg.getGame().getId()==g.getId()){
                    p.add(modelMapper.map(pg.getPlayer(),PlayerViewModel.class));
                }
            }
            gfm.setPlayers(p);
            gameViewModels.add(gfm);
        }

        return gameViewModels;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GameViewModel> getGameById(@PathVariable int id)
    {
        Collection<Integer>  pid =new ArrayList<>();
        var game = _iGameService.getGameById(id);
        if(game.isPresent()){
        GameViewModel singleGame = modelMapper.map(game.get(), GameViewModel.class);
        singleGame.setSeries_id(game.get().getId());
        var allPlayGame =_iPlaGameService.getAllPlayGame();
            for (PlayGame pg:allPlayGame) {
                if(pg.getGame().getId()==game.get().getId()){
                    pid.add(pg.getPlayer().getId());
                }
            }
            singleGame.setPlayer_id(pid);
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