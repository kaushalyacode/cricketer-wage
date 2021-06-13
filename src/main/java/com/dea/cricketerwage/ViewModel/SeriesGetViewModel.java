package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeriesGetViewModel {
    private int id;

    private String name;

    private Float prize;

    private int playerOfSeries;
}
