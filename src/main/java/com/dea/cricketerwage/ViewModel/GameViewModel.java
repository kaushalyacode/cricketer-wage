package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameViewModel  extends BaseEntityViewModel{

    private int id;

    private String name;

    private boolean isWin;

    private boolean isDefeate;

    private boolean isDraw;

    private int series_id;

}