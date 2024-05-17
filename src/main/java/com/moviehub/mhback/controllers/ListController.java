package com.moviehub.mhback.controllers;

import com.moviehub.mhback.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://moviehub.es")
@RequestMapping("/lists")
public class ListController {

    @Autowired
    private ListRepository listRepository;

    @GetMapping("/{listId}")
    public com.moviehub.mhback.entities.List getListById(@PathVariable long listId) {
        return listRepository.findById(listId).orElse(null);
    }

    @GetMapping("/user/{userId}")
    public java.util.List<com.moviehub.mhback.entities.List> getListsByUserId(@PathVariable String userId) {
        return listRepository.findListsByUserId(userId);
    }

    @PostMapping
    public com.moviehub.mhback.entities.List createList(@RequestBody com.moviehub.mhback.entities.List newList) {
        return listRepository.save(newList);
    }

    @DeleteMapping("/{listId}")
    public void deleteList(@PathVariable long listId) {
        listRepository.deleteById(listId);
    }
}
