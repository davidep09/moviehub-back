package com.moviehub.mhback.repositories;

import com.moviehub.mhback.entities.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
    @Query("SELECT il FROM ItemList il WHERE il.listId = ?1")
    java.util.List<ItemList> findItemsByListId(long listId);
}