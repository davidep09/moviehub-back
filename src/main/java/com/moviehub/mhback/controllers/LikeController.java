package com.moviehub.mhback.controllers;

import com.moviehub.mhback.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping("most-liked")
    public java.util.List<com.moviehub.mhback.entities.Like> getMostLiked() {
        return likeRepository.findMostLiked();
    }

    @GetMapping("/{userId}")
    public java.util.List<com.moviehub.mhback.entities.Like> getLikesByUserId(@PathVariable String userId) {
        return likeRepository.findLikesByUserId(userId);
    }

    @GetMapping("/movie/{movieId}")
    public java.util.List<com.moviehub.mhback.entities.Like> getLikesByMovieId(@PathVariable long movieId) {
        return likeRepository.findLikesByMovieId(movieId);
    }

    @GetMapping("/movie/{movieId}/{userId}")
    public com.moviehub.mhback.entities.Like getLikeByMovieIdAndUserId(@PathVariable long movieId, @PathVariable String userId) {
        return likeRepository.findLikeByMovieIdAndUserId(movieId, userId);
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
