package com.moviehub.mhback.controllers;

import com.moviehub.mhback.entities.Like;
import com.moviehub.mhback.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping("/{userId}")
    public List<Like> getLikesByUserId(@PathVariable String userId) {
        return likeRepository.findLikesByUserId(userId);
    }

    @GetMapping("/movie/{movieId}")
    public List<Like> getLikesByMovieId(@PathVariable long movieId) {
        return likeRepository.findLikesByMovieId(movieId);
    }

    @GetMapping("/movie/{movieId}/{userId}")
    public Like getLikeByMovieIdAndUserId(@PathVariable long movieId, @PathVariable String userId) {
        return likeRepository.findLikeByMovieIdAndUserId(movieId, userId);
    }

    @PostMapping
    public Like addLike(@RequestBody Like like) {
        return likeRepository.save(like);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable long likeId) {
        likeRepository.deleteById(likeId);
    }

    @GetMapping("top5")
    public List<Object[]> getTop5LikedMovies() {
        return likeRepository.getTop5LikedMovies(PageRequest.of(0, 5));
    }
}