package com.moviehub.mhback.controllers;

import com.moviehub.mhback.entities.ItemList;
import com.moviehub.mhback.repositories.ItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/itemslist")
public class ItemListController {

    @Autowired
    private ItemListRepository listRepository;

    @GetMapping("/{listId}")
    public java.util.List<ItemList> getItemsByListId(@PathVariable long listId) {
        return listRepository.findItemsByListId(listId);
    }

    @PostMapping
    public ItemList addItemToList(@RequestBody ItemList item) {
        return listRepository.save(item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItemFromList(@PathVariable long itemId) {
        listRepository.deleteById(itemId);
    }

}