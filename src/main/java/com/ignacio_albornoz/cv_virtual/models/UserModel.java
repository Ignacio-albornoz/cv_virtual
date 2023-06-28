package com.ignacio_albornoz.cv_virtual.models;

import com.ignacio_albornoz.cv_virtual.repositories.CategoriesRepository;
import com.ignacio_albornoz.cv_virtual.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.*;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseModel> course = new HashSet<>();


    private String firstName;
    private String SecondName;
    @Column(unique = true, nullable = false)
    private String email;
    private LocalDate birthdate;
    private String skills;
    private List<String> SocialMedia;
    private enum Availability {
        FULL_TIME,
        PART_TIME,
        NONE
    }
    private Availability availability;
    private String additionalInformation;

    public Long getId() {
        return id;
    }

    public Set<CourseModel> getCourse() {
        return course;
    }

    public void setCourse(Set<CourseModel> course) {
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<String> getSocialMedia() {
        return SocialMedia;
    }

    public void setSocialMedia(List<String> socialMedia) {
        SocialMedia = socialMedia;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }


    public String getAvailability() {
        String content = availability.toString();
        return content;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Service
    public static class UserService {
        @Autowired
        UserRepository userRepository;

        public ArrayList<UserModel> getUser(){
            return (ArrayList<UserModel>) userRepository.findAll();
        }

        public UserModel saveUser(UserModel category){
            return (UserModel) userRepository.save(category);
        }

        public Optional<UserModel> getUserById(Long id){
            return userRepository.findById(id);
        }

        public ArrayList<UserModel> getUserByEmail(String email){
            return userRepository.findByEmail(email);
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
