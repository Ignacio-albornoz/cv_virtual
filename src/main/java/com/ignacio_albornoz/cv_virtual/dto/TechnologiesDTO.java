package com.ignacio_albornoz.cv_virtual.dto;

import com.ignacio_albornoz.cv_virtual.models.TechnologiesModel;

public class TechnologiesDTO {
    private Long id;
    private String title;
    private String description;

    public TechnologiesDTO(TechnologiesModel technology) {
        this.id = technology.getId();
        this.title = technology.getTitle();
        this.description = technology.getDescription();
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
