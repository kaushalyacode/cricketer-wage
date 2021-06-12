package com.dea.cricketerwage.ViewModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntityViewModel {
    private boolean isActive;

    private boolean isDeleted;

    private Date addedDateTime;

    private Date  updatedDateTime;
}