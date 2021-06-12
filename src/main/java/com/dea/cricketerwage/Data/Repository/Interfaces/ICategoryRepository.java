package com.dea.cricketerwage.Data.Repository.Interfaces;

import com.dea.cricketerwage.Data.Model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Integer> {
}