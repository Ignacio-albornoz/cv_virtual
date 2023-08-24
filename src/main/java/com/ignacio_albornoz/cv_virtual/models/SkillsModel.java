package com.ignacio_albornoz.cv_virtual.models;

import com.ignacio_albornoz.cv_virtual.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Optional;

@Entity
@Table(name = "skills")
public class SkillsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String skills;
    private String area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private UserModel users;

    public UserModel getUser() {
        return users;
    }

    public void setUser(UserModel user) {
        this.users = user;
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

    @Service
    public static class SkillsService {
        @Autowired
        SkillsRepository skillsRepository;

        public ArrayList<SkillsModel> getSkill(){
            return (ArrayList<SkillsModel>) skillsRepository.findAll();
        }

        public SkillsModel saveSkill(SkillsModel skills){
            return (SkillsModel) skillsRepository.save(skills);
        }

        public Optional<SkillsModel> getSkillById(Long id){
            return skillsRepository.findById(id);
        }

        public boolean deleteSkill(Long id){
            try {
                skillsRepository.deleteById(id);
                return true;
            }catch (Exception err){
                return false;
            }
        }
    }
}
