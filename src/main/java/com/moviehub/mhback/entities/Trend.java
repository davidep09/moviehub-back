package com.moviehub.mhback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TRENDS")
public class Trend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long likes;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
