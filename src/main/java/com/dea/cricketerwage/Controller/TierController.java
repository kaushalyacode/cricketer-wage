package com.dea.cricketerwage.Controller;

import com.dea.cricketerwage.Data.Model.Category;
import com.dea.cricketerwage.Data.Model.Tier;
import com.dea.cricketerwage.Services.Interfaces.ICategoryService;
import com.dea.cricketerwage.Services.Interfaces.ITierService;
import com.dea.cricketerwage.ViewModel.TierViewModel;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("tier")
public class TierController {

    @Autowired
    private ITierService _iTierService;

    @Autowired
    private ICategoryService _iCategoryService;

    private ModelMapper modelMapper;

    public TierController()
    {
        modelMapper = new ModelMapper();
    }

    @GetMapping("/get")
    public Collection<TierViewModel> getAllTiers()
    {
        var tiers = _iTierService.getAllTieries();
        Collection<TierViewModel> tierViewModels = new ArrayList<>();
        for (Tier t: tiers)
        {
            var tierViewModel = new TierViewModel();
            tierViewModel.setId(t.getId());
            tierViewModel.setName(t.getName());
            tierViewModel.setAmount(t.getAmount());
            tierViewModel.setCategory_id(t.getCategory().getId());
            tierViewModels.add(tierViewModel);
        }
        return tierViewModels;
    }

    @PostMapping("/add")
    public ResponseEntity<TierViewModel> AddTier(@RequestBody TierViewModel tierViewModel)
    {
        Tier tier = modelMapper.map(tierViewModel, Tier.class);

        if(getCategoryDatails(tierViewModel.getCategory_id())!=null)
        {
            tier.setCategory(getCategoryDatails(tierViewModel.getCategory_id()));
            var createdTier =  _iTierService.addTier(tier);

            TierViewModel tvm =modelMapper.map(createdTier,TierViewModel.class);
            tvm.setCategory_id(tierViewModel.getCategory_id());
            return new ResponseEntity<>(tvm, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TierViewModel> getTierId(@PathVariable int id)
    {
        var tier =_iTierService.getTierById(id);
        if(tier.isPresent())
        {
            TierViewModel singleTier = modelMapper.map(tier.get(), TierViewModel.class);
            singleTier.setCategory_id(tier.get().getCategory().getId());
            return new ResponseEntity<>(singleTier, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    private Category getCategoryDatails(int id)
    {
        var category = _iCategoryService.getCategoryById(id);
        if(category.isPresent())
        {
           return category.get();
        }
        else
            {
            return null;
        }
    }
}