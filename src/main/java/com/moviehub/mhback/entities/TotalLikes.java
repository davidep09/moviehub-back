package com.moviehub.mhback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TOTAL_LIKES")
public class TotalLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int likes;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
