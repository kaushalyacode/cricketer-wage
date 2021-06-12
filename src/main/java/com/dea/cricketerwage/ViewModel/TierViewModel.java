package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierViewModel  extends BaseEntityViewModel{

    private int id;

    private String name;

    private float amount;

    private int category_id;

}