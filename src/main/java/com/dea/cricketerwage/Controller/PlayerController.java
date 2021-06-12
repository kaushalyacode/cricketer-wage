package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Game;
import com.dea.cricketerwage.Data.Model.Player;
import com.dea.cricketerwage.Services.Interfaces.ICategoryService;
import com.dea.cricketerwage.Services.Interfaces.IGameService;
import com.dea.cricketerwage.Services.Interfaces.IPlayerService;
import com.dea.cricketerwage.ViewModel.PlayerViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("player")
public class PlayerController
{
    @Autowired
    private IPlayerService _iPlayerService;

    @Autowired
    private ICategoryService _iCategoryService;

    @Autowired
    private IGameService _iGameService;

    private  ModelMapper modelMapper;

    public PlayerController()
    {
        modelMapper = new ModelMapper();
    }

    @GetMapping("/get")
   public Collection<PlayerViewModel> getAllPlayers()
    {
        var players = _iPlayerService.getAllPlayers();
        Collection<PlayerViewModel> playerViewModels = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        players.forEach(player -> playerViewModels.add(mapper.map(player, PlayerViewModel.class)));
        return playerViewModels;
    }

    @PostMapping("/add")
    public PlayerViewModel AddPlayer(@RequestBody PlayerViewModel playerViewModel)
    {
            Player player = modelMapper.map(playerViewModel, Player.class);
            int category_id= playerViewModel.getCategory_id();
            if(_iCategoryService.getCategoryById(category_id).isPresent())
            {
                player.setCategory(_iCategoryService.getCategoryById(category_id).get());
            }
            else{
                return null;
            }
            Set<Game> games=new HashSet<Game>();
            for (int id: playerViewModel.getGame_id())
            {
                games.add(_iGameService.getGameById(id).get());
            }
            player.setGames(games);
            var playerCreatred =_iPlayerService.addPlayer(player);
            if(playerCreatred!=null)
            {
               return playerViewModel;
            }else{

                return null;
            }
    }

    @GetMapping("/get/{id}")
    public PlayerViewModel getPlayerId(@PathVariable int id)
    {
        var player =_iPlayerService.getPlayerById(id);
        if(player.isPresent())
        {
        PlayerViewModel singlePlayer = modelMapper.map(player.get(), PlayerViewModel.class);
        return singlePlayer;
        }
        return null;
    }
}