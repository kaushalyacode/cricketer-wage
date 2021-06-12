package com.dea.cricketerwage.ViewModel;

import com.dea.cricketerwage.Data.Model.Category;
import com.dea.cricketerwage.Data.Model.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PlayerFullViewModel {

    private int id;

    private String fullName;

    private int jersyNumber;

    private int age;

    private Set<Game> games;

    private Category category;
}