package com.ignacio_albornoz.cv_virtual.response;

public class UserCourse {
    private String email;
    private String title;

    public UserCourse( String email, String title) {
        this.email = email;
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


