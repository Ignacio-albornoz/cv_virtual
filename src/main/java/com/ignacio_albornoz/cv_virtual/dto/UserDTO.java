package com.ignacio_albornoz.cv_virtual.dto;

import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import com.ignacio_albornoz.cv_virtual.models.SkillsModel;
import com.ignacio_albornoz.cv_virtual.models.UserModel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private Long phone;
    private LocalDate birthdate;
    private String availability;
    private String additionalInformation;

    private Set<String> skills = new HashSet<>();

    private Set<CoursesDTO> courses = new HashSet<>();

    private Set<Long> courseId = new HashSet<>();

    public UserDTO(UserModel user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.birthdate = user.getBirthdate();
        this.availability = user.getAvailability();
        this.additionalInformation = user.getAdditionalInformation();

        for (SkillsModel skills : user.getSkills()) {
            SkillsDTO skillsDTO = new SkillsDTO(skills);
            this.skills.add(skillsDTO.getSkills());
        }

        /*for (CourseModel course : user.getCourses()) {
            CoursesDTO coursesDTO = new CoursesDTO(course);
            this.courses.add(coursesDTO);
        }*/

        for (CourseModel courses : user.getCourses()) {
            CoursesDTO coursesDTO = new CoursesDTO(courses);
            this.courseId.add(coursesDTO.getId());
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.secondName = secondName;
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

    public Set<Long> getCourseId() {
        return courseId;
    }

    public void setCourseId(Set<Long> courseId) {
        this.courseId = courseId;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Set<CoursesDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CoursesDTO> courses) {
        this.courses = courses;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
