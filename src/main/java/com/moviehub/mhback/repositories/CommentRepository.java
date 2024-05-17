package com.moviehub.mhback.repositories;

import com.moviehub.mhback.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.type = 'movie' AND c.movieId = ?1")
    List<Comment> findByMovieId(int movieId);

    @Query("SELECT c FROM Comment c WHERE c.type = 'tv' AND c.movieId = ?1")
    List<Comment> findBySerieId(int movieId);

    @Query("SELECT c FROM Comment c WHERE c.userId = ?1")
    List<Comment> findByUserId(String userId);
}
