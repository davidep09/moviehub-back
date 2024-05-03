package com.moviehub.mhback.controllers;

import com.moviehub.mhback.entities.ItemList;
import com.moviehub.mhback.repositories.ItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itemslist")
public class ItemListController {

    @Autowired
    private ItemListRepository listRepository;

    @GetMapping("/{listId}")
    public java.util.List<ItemList> getItemsByListId(@PathVariable long listId) {
        return listRepository.findItemsByListId(listId);
    }
}