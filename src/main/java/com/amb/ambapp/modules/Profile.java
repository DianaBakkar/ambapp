package com.amb.ambapp.modules;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String FName;
    private String LName;
    private Date DOB;
    private String email;

    @OneToOne(mappedBy = "profileId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Users user;




    public Profile(int id, String FName, String LName, Date DOB, String email) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
        this.DOB = DOB;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

