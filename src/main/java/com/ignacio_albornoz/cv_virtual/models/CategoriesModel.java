package com.ignacio_albornoz.cv_virtual.models;

import com.ignacio_albornoz.cv_virtual.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "categories")
    private Set<CourseModel> courses;

    @Column(unique = true, nullable = false)
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Service
    public static class CategoriesService {
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
}