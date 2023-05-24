package com.ignacio_albornoz.cv_virtual.services;

import com.ignacio_albornoz.cv_virtual.models.CategoriesModel;
import com.ignacio_albornoz.cv_virtual.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    public ArrayList<CategoriesModel> getCategories(){
        return (ArrayList<CategoriesModel>) categoriesRepository.findAll();
    }

    public CategoriesModel saveCategories(CategoriesModel category){
        return (CategoriesModel) categoriesRepository.save(category);
    }

    public Optional<CategoriesModel> getCategoriesById(Long id){
        return categoriesRepository.findById(id);
    }

    public ArrayList<CategoriesModel> getCategoriesByTitle(String title){
        return categoriesRepository.findByTitle(title);
    }

    public boolean deleteCategories(Long id){
        try {
            categoriesRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}