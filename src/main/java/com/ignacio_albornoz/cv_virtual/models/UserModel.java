package com.ignacio_albornoz.cv_virtual.models;


import com.ignacio_albornoz.cv_virtual.dto.SkillsDTO;
import com.ignacio_albornoz.cv_virtual.repositories.SkillsRepository;
import com.ignacio_albornoz.cv_virtual.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<SkillsModel> skills = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseModel> courses = new HashSet<>();


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true)
    private Long phone;
    private LocalDate birthdate;
    private enum Availability {
        FULL_TIME,
        PART_TIME,
        NONE
    }
    private Availability availability;
    @Column(name = "additional_information")
    private String additionalInformation;

    public Long getId() {
        return id;
    }

    public Set<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseModel> course) {
        this.courses = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /*public List<SkillsModel> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsModel> skills) {
        this.skills = skills;
    }

    public void addSkill(SkillsModel skill) {
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(skill);
    }*/




    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getAvailability() {
        if (availability != null){
            String content = this.availability.toString();
            return content;
        }
        return "";
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Set<SkillsModel> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillsModel> skills) {
        this.skills = skills;
    }

    public void addSkill(SkillsModel skill) {
        skills.add(skill);
        skill.setUser(this);
    }


    @Service
    public static class UserService {
        @Autowired
        UserRepository userRepository;

        @Autowired
        SkillsRepository skillsRepository;

        public ArrayList<UserModel> getUser(){
            return (ArrayList<UserModel>) userRepository.findAll();
        }

        public UserModel saveUser(UserModel user){
            return (UserModel) userRepository.save(user);
        }


        public Optional<UserModel> getUserById(Long id){
            return userRepository.findById(id);
        }

        public ArrayList<UserModel> getUserByEmail(String email){
            return userRepository.findByEmail(email);
        }

        public ArrayList<String> getCoursesTitleByUserId(Long id) { return userRepository.findCoursesTitleByUserId(id); }

        public ArrayList<String> getSkillsByUserId(Long id){ return userRepository.findSkillsByUserId(id); }

        public String addSkills(String skills, Long id){ return userRepository.addSkills(skills, id); }

        /*public void addSkill(Long userId, String skills, String area) {
            UserModel user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            SkillsModel skill = new SkillsModel();
            skill.setId(userId);
            skill.setSkills(skills);
            skill.setArea(area);
            user.addSkill(skill);

            userRepository.save(user);
        }*/

        public UserModel addSkillToUser(Long userId, Long skillId) {
            UserModel user = userRepository.findById(userId).orElse(null);
            SkillsModel skill = skillsRepository.findById(skillId).orElse(null);

            if (user != null && skill != null) {
                user.addSkill(skill);
                userRepository.save(user);
            }

            return user;
        }

        public boolean deleteUser(Long id){
            try {
                userRepository.deleteById(id);
                return true;
            }catch (Exception err){
                return false;
            }
        }
    }
}
