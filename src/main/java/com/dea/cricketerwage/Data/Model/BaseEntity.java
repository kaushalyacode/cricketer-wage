package com.dea.cricketerwage.Data.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity{

    private boolean isActive;

    private boolean isDeleted;

    private Date addedDateTime;

    private Date  updatedDateTime;

}