package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.models.CategoriesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoriesModel.CategoriesService categoriesService;

    @GetMapping()
    public ArrayList<CategoriesModel> getCategories(){
        return categoriesService.getCategories();
    }

    @PostMapping()
    public CategoriesModel saveCategories(@RequestBody CategoriesModel category){
        return this.categoriesService.saveCategories(category);
    }

    @GetMapping( path = "/{id}")
    public Optional<CategoriesModel> getCategoriesById(@PathVariable("id") Long id){
        return this.categoriesService.getCategoriesById(id);
    }

    @GetMapping("/query")
    public ArrayList<CategoriesModel> getCategoriesByTitle(@RequestParam("title") String title){
        return this.categoriesService.getCategoriesByTitle(title);
    }

}
