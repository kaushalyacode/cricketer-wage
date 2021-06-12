package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Category;
import com.dea.cricketerwage.Services.Interfaces.ICategoryService;
import com.dea.cricketerwage.ViewModel.CategoryViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("category")
public class CategoryInfoController {

    @Autowired
    private ICategoryService _iCategoryService;
    private ModelMapper modelMapper;

    public CategoryInfoController()
    {
        modelMapper = new ModelMapper();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> AddCategory(@RequestBody CategoryViewModel categoryViewModel)
    {
        Category category = modelMapper.map(categoryViewModel, Category.class);
        var singleCategory= _iCategoryService.addCategory(category);
        return new ResponseEntity<>(singleCategory, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Collection<CategoryViewModel>> getAllCategory()
    {
        var categories = _iCategoryService.getAllCategories();
        Collection<CategoryViewModel> categoryViewModels = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        categories.forEach(category -> categoryViewModels.add(mapper.map(category, CategoryViewModel.class)));
        return new ResponseEntity<>(categoryViewModels, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryViewModel> getCategoryById(@PathVariable int id)
    {
        var category = _iCategoryService.getCategoryById(id);
        if(category.isPresent())
        {
            CategoryViewModel singleCategory = modelMapper.map(category.get(), CategoryViewModel.class);
            return new ResponseEntity<>(singleCategory, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
    }
}