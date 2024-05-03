package com.moviehub.mhback.repositories;

import com.moviehub.mhback.entities.TotalLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TotalLikesRepository extends JpaRepository<TotalLikes, Long> {
    @Query("SELECT t FROM TotalLikes t ORDER BY t.likes DESC LIMIT 5")
    List<TotalLikes> getMostLikedMovies();
}
