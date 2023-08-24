package com.ignacio_albornoz.cv_virtual.dto;

import com.ignacio_albornoz.cv_virtual.models.CategoriesModel;
import com.ignacio_albornoz.cv_virtual.models.TechnologiesModel;
import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import com.ignacio_albornoz.cv_virtual.models.UserModel;


import java.util.HashSet;
import java.util.Set;

public class CoursesDTO {
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private Integer startYear;
    private Integer startMonth;
    private Integer finishedYear;
    private Integer finishedMonth;
    private String establishment;

    private Set<TechnologiesDTO> technologies = new HashSet<>();

    private Set<CategoriesDTO> categories = new HashSet<>();

    public CoursesDTO(CourseModel course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.duration = course.getDuration();
        this.startYear = course.getStartYear();
        this.startMonth = course.getStartMonth();
        this.finishedYear = course.getFinishedYear();
        this.finishedMonth = course.getFinishedMonth();
        this.establishment = course.getEstablishment();
        for (CategoriesModel category : course.getCategories()) {
            CategoriesDTO categoryDTO = new CategoriesDTO(category);
            this.categories.add(categoryDTO);
        }

        for (TechnologiesModel technology : course.getTechnologies()) {
            TechnologiesDTO technologyDTO = new TechnologiesDTO(technology);
            this.technologies.add(technologyDTO);
        }


    }




    /*Getters & Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getFinishedYear() {
        return finishedYear;
    }

    public void setFinishedYear(Integer finishedYear) {
        this.finishedYear = finishedYear;
    }

    public Integer getFinishedMonth() {
        return finishedMonth;
    }

    public void setFinishedMonth(Integer finishedMonth) {
        this.finishedMonth = finishedMonth;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public Set<TechnologiesDTO> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<TechnologiesDTO> technologies) {
        this.technologies = technologies;
    }

    public Set<CategoriesDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesDTO> categories) {
        this.categories = categories;
    }
}

/*
*/