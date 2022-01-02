package com.amb.ambapp.modules;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private int valid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeId",nullable = false)
    private Types typeId;


    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "profileId")
    private Profile profileId;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Favorites> favorites;



    public Users() {
        super();
    }

    public Users(int id, String username, String password, int valid,Types typeId,Profile profileId) {
        id = id;
        this.username = username;
        this.password = password;
        this.valid = valid;
        this.typeId=typeId;
        this.profileId=profileId;
    }

    public int getId() {
        return this.id;
    }

    public Types getTypeId() {
        return typeId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getValid() {
        return this.valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public void setTypeId(Types typeId) {
        this.typeId = typeId;
    }
}


