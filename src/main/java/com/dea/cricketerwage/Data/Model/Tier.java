package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Tier" ,schema = "public")
public class Tier extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tier_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "tier_name",nullable = false,updatable = true)
    private String name;

    @Column(name = "tier_amount",nullable = false,updatable = true)
    private float amount;
}
