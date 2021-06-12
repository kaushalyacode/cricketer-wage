package com.dea.cricketerwage.Services.Interfaces;

import com.dea.cricketerwage.Data.Model.Category;

import java.util.Optional;

public interface ICategoryService {
    public Iterable<Category> getAllCategories();
    public Optional<Category> getCategoryById(int id);
    public Category addCategory(Category category);
}