package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Game;
import com.dea.cricketerwage.Data.Model.PlayGame;
import com.dea.cricketerwage.Data.Model.Player;
import com.dea.cricketerwage.Services.Interfaces.ICategoryService;
import com.dea.cricketerwage.Services.Interfaces.IGameService;
import com.dea.cricketerwage.Services.Interfaces.IPlayerService;
import com.dea.cricketerwage.Services.Interfaces.ITierService;
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

    @Autowired
    private ITierService _iTierService;

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
        for (Player p:players)
        {
            Collection<Integer> gameIds= new ArrayList<>();
            var playerViewModel = new PlayerViewModel();
            playerViewModel.setId(p.getId());
            playerViewModel.setAge(p.getAge());
            playerViewModel.setFullName(p.getFullName());
            playerViewModel.setJersyNumber(p.getJersyNumber());
            playerViewModel.setTier_id(p.getTier().getId());
            playerViewModel.setCategory_id(p.getCategory().getId());
            playerViewModels.add(playerViewModel);
        }
        return playerViewModels;
    }

    @PostMapping("/add")
    public PlayerViewModel AddPlayer(@RequestBody PlayerViewModel playerViewModel)
    {
            Player player = modelMapper.map(playerViewModel, Player.class);
            int category_id= playerViewModel.getCategory_id();
            int tier_id= playerViewModel.getTier_id();
            if(_iCategoryService.getCategoryById(category_id).isPresent())
            {
                player.setCategory(_iCategoryService.getCategoryById(category_id).get());
                if(_iTierService.getTierById(tier_id).isPresent())
                {
                    player.setTier(_iTierService.getTierById(tier_id).get());
                }
                else{
                    return null;
                }
            }
            else{
                return null;
            }
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
        singlePlayer.setCategory_id(player.get().getCategory().getId());
        singlePlayer.setTier_id(player.get().getTier().getId());
        Collection<Integer> gid =  new ArrayList<>();

        return singlePlayer;
        }
        return null;
    }
}