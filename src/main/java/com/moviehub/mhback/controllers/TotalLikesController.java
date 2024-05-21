package com.moviehub.mhback.controllers;

import com.moviehub.mhback.entities.TotalLikes;
import com.moviehub.mhback.repositories.TotalLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/totalLikes")
public class TotalLikesController {
    @Autowired
    private TotalLikesRepository totalLikesRepository;

    @GetMapping
    public List<TotalLikes> getMostLikedMovies() {
        return totalLikesRepository.getMostLikedMovies();
    }

    @GetMapping("/{type}/{movieId}")
    public TotalLikes getTotalLikesByMovieId(@PathVariable String type, @PathVariable long movieId) {
        return totalLikesRepository.findTotalLikesByMovieId(type, movieId);
    }

    @PostMapping("/update")
    public TotalLikes updateTotalLikes(@RequestBody TotalLikes totalLikes) {
        return totalLikesRepository.save(totalLikes);
    }
}
