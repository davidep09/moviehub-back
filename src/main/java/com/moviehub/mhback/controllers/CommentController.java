package com.moviehub.mhback.controllers;

import com.moviehub.mhback.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/movie/{movieId}")
    public java.util.List<com.moviehub.mhback.entities.Comment> getCommentsByMovieId(@PathVariable int movieId) {
        return commentRepository.findByMovieId(movieId);
    }

    @GetMapping("/tv/{movieId}")
    public java.util.List<com.moviehub.mhback.entities.Comment> getCommentsBySerieId(@PathVariable int movieId) {
        return commentRepository.findBySerieId(movieId);
    }

    @GetMapping("/user/{userId}")
    public java.util.List<com.moviehub.mhback.entities.Comment> getCommentsByUserId(@PathVariable String userId) {
        return commentRepository.findByUserId(userId);
    }

    @PostMapping
    public com.moviehub.mhback.entities.Comment addComment(@RequestBody com.moviehub.mhback.entities.Comment comment) {
        return commentRepository.save(comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable long commentId) {
        commentRepository.deleteById(commentId);
    }
}
