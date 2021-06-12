package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class PlayerViewModel  extends BaseEntityViewModel{

    private int id;

    private String fullName;

    private int jersyNumber;

    private int age;

    private int category_id;

    private Collection<Integer> game_id;
}