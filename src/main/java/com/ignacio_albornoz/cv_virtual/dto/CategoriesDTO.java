package com.ignacio_albornoz.cv_virtual.dto;

import com.ignacio_albornoz.cv_virtual.models.CategoriesModel;

public class CategoriesDTO {
    private Long id;
    private String title;
    private String description;

    public CategoriesDTO(CategoriesModel category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.description = category.getDescription();
    }

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
}
