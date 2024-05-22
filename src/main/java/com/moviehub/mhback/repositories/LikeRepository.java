package com.moviehub.mhback.repositories;

import com.moviehub.mhback.entities.Like;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT l FROM Like l WHERE l.userId = ?1")
    List<Like> findLikesByUserId(String userId);

    @Query("SELECT l FROM Like l WHERE l.movieId = ?1")
    List<Like> findLikesByMovieId(long movieId);

    @Query("SELECT l FROM Like l WHERE l.movieId = ?1 AND l.userId = ?2")
    Like findLikeByMovieIdAndUserId(long movieId, String userId);

    @Query("SELECT l.movieId, l.type, COUNT(l) as likes FROM Like l GROUP BY l.movieId, l.type ORDER BY likes DESC")
    List<Object[]> getTop5LikedMovies(Pageable pageable);
}