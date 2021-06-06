package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Game" ,schema = "public")
public class Game extends BaseEntity{

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

    //many to many bidirectionl
    @ManyToMany
    @JoinTable(name="game_players")
    private Set<Player> players;

     //Many to one unidirectional
     @ManyToOne(optional = false)
     @JoinColumn(name="series_id")
     private Series series;
}