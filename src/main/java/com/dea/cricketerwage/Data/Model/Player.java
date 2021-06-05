package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Player" ,schema = "public")
public class Player extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "player_full_name",nullable = false,updatable = true)
    private String fullName;

    @Column(name = "player_jersyNumber",nullable = false,updatable = true)
    private int jersyNumber;

    @Column(name = "player_age",nullable = false,updatable = false)
    private int age;
}