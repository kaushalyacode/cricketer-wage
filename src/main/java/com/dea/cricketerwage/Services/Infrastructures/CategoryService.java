package com.dea.cricketerwage.Services.Infrastructures;

import com.dea.cricketerwage.Data.Model.Category;
import com.dea.cricketerwage.Data.Repository.Interfaces.ICategoryRepository;
import com.dea.cricketerwage.Services.Interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository _iCategoryRepository;

    @Override
    public Iterable<Category> getAllCategories() {
      return _iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return _iCategoryRepository.findById(id);
    }

    @Override
    public Category addCategory(Category category)
    {
        return _iCategoryRepository.save(category);
    }
}