package com.moviehub.mhback.repositories;

import com.moviehub.mhback.entities.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListRepository extends JpaRepository<List, Long> {
    @Query("SELECT l FROM List l WHERE l.userId = ?1")
    java.util.List<List> findListsByUserId(String userId);


}