package com.example.joblist.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Arrays;
import java.util.Date;

@Document(collection = "posts") // This tells MongoDB to make a collection called "posts"
public class Post {
    @Id
    private String id;
    private String profile;
    private String description;
    private int experience;
    private String techs[];
    private String location;
    private Date createdAt = new Date();

    private Date updatedAt = new Date();




    // Getters and Setters are ways to access private variables in a class
    // -> Right Click -> Source -> Generate Getters and Setters,
    // highlight all fields and click ok

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public String getId() {
        return id;
    }


    // toString() method to print the object in a readable format
    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                "profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", techs=" + Arrays.toString(techs) +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
