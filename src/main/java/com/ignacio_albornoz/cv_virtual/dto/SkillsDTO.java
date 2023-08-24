package com.ignacio_albornoz.cv_virtual.dto;

import com.ignacio_albornoz.cv_virtual.models.SkillsModel;

import java.util.ArrayList;


public class SkillsDTO {

    private Long id;
    private String skills;
    private String area;

    public SkillsDTO(SkillsModel skills) {
        this.id = skills.getId();
        this.skills = skills.getSkills();
        this.area = skills.getArea();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
