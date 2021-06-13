package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="playerSeries",schema = "public")
public class PlaySeries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_series_id",nullable = false,updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    @Column(name="isManOfSeries")
    private boolean isManOfSeries;
}