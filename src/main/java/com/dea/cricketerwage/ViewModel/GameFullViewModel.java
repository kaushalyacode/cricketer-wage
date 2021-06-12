package com.dea.cricketerwage.ViewModel;

import com.dea.cricketerwage.Data.Model.Player;
import com.dea.cricketerwage.Data.Model.Series;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class GameFullViewModel {

    private int id;

    private String name;

    private boolean isWin;

    private boolean isDefeate;

    private boolean isDraw;

    private Set<PlayerViewModel> players;

    private SeriesViewModel series;
}