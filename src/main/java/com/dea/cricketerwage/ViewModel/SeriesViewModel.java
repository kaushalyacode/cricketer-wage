package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class SeriesViewModel {

    private int id;

    private String name;

    private Float prize;

    private int playerOfSeries;

    private Collection<Integer> player_id;

}