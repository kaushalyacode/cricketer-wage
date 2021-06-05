package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Series" ,schema = "public")
public class Series extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "series_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "series_name",nullable = false,updatable = true)
    private String name;

    @Column(name = "series_prize",nullable = false,updatable = true)
    private Float prize;
}
