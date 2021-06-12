package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class GameViewModel{

    private int id;

    private String name;

    private boolean isWin;

    private boolean isDefeate;

    private boolean isDraw;

    private int series_id;

    private Collection<Integer>  player_id;

}