package com.dea.cricketerwage.Controller;


import com.dea.cricketerwage.Data.Model.Player;
import com.dea.cricketerwage.Services.Interfaces.IPlayerService;
import com.dea.cricketerwage.ViewModel.PlayerViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("wage")
public class WageController {

   /* @Autowired
    private IPlayerService _iPlayerService;
    private ModelMapper modelMapper;

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
    public Player AddPlayer(@RequestBody PlayerViewModel playerViewModel)
    {
        Player player = modelMapper.map(playerViewModel, Player.class);
        return _iPlayerService.addPlayer(player);
    }
    @GetMapping("/get/{id}")
    public PlayerViewModel getPlayerId(@PathVariable int id)
    {
        var player =_iPlayerService.getPlayerById(id);
        ModelMapper mapper = new ModelMapper();
        PlayerViewModel singlePlayer = modelMapper.map(player.get(), PlayerViewModel.class);
        return singlePlayer;
    }
*/



}
