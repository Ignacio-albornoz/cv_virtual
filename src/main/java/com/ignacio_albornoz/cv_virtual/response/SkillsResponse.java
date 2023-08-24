package com.ignacio_albornoz.cv_virtual.response;

import java.util.ArrayList;

public class SkillsResponse {

        private String name;
        private String email;
        private ArrayList<String> skills;

        public SkillsResponse(String name, String email, ArrayList<String> skills) {
            this.name = name;
            this.email = email;
            this.skills = skills;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
