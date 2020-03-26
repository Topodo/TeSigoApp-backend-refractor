package com.edutools.tesigoapp.repositories;

import com.edutools.tesigoapp.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
