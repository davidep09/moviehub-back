package com.moviehub.mhback.repositories;

import com.moviehub.mhback.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<User, Integer> {

}
