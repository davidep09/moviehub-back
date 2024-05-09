package com.moviehub.mhback.controllers;

import com.moviehub.mhback.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping("/{userId}")
    public java.util.List<com.moviehub.mhback.entities.Like> getLikesByUserId(@PathVariable String userId) {
        return likeRepository.findLikesByUserId(userId);
    }

    @GetMapping("/movie/{movieId}")
    public java.util.List<com.moviehub.mhback.entities.Like> getLikesByMovieId(@PathVariable long movieId) {
        return likeRepository.findLikesByMovieId(movieId);
    }

    @PostMapping
    public com.moviehub.mhback.entities.Like addLike(@RequestBody com.moviehub.mhback.entities.Like like) {
        return likeRepository.save(like);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable long likeId) {
        likeRepository.deleteById(likeId);
    }

}
