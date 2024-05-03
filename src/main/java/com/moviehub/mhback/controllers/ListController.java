package com.moviehub.mhback.controllers;

import com.moviehub.mhback.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
