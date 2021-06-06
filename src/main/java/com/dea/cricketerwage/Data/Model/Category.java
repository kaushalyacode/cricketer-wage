package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Category" ,schema = "public")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "category_name",nullable = false,updatable = true)
    private String name;

    //one to many bidirectional
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "category")
    private Set<Tier> tier;
}