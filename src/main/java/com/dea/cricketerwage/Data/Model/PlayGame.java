package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="playerGame",schema = "public")
public class PlayGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_game_id",nullable = false,updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
