package com.moviehub.mhback.controllers;

import com.moviehub.mhback.entities.TotalLikes;
import com.moviehub.mhback.repositories.TotalLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/totalLikes")
public class TotalLikesController {

    @Autowired
    private TotalLikesRepository totalLikesRepository;

    @GetMapping
    public List<TotalLikes> getMostLikedMovies() {
        return totalLikesRepository.getMostLikedMovies();
    }
}
