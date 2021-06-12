package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeriesViewModel  extends BaseEntityViewModel{

    private int id;

    private String name;

    private Float prize;
}