package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Game_details" ,schema = "public")
public class Game{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "game_name",nullable = true,updatable = true)
    private String name;

    @Column(name = "isWin",nullable = false,updatable = true)
    private boolean isWin;

    @Column(name = "isDefeate",nullable = false,updatable = true)
    private boolean isDefeate;

    @Column(name = "isDraw",nullable = false,updatable = true)
    private boolean isDraw;

    @OneToMany(mappedBy = "game")
    Set<PlayGame> PlayerGame;

     //Many to one unidirectional
     @ManyToOne(optional = false)
     @JoinColumn(name="series_id")
     private Series series;
}