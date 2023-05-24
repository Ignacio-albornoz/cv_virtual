package com.ignacio_albornoz.cv_virtual.repositories;

import com.ignacio_albornoz.cv_virtual.models.CategoriesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoriesRepository extends CrudRepository<CategoriesModel, Long> {
    public abstract ArrayList<CategoriesModel> findByTitle(String title);
}

