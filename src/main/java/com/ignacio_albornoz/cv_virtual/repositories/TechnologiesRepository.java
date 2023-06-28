package com.ignacio_albornoz.cv_virtual.repositories;

import com.ignacio_albornoz.cv_virtual.models.TechnologiesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TechnologiesRepository extends CrudRepository<TechnologiesModel, Long> {
    public abstract ArrayList<TechnologiesModel> findByTitle(String title);
}