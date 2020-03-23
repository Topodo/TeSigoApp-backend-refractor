package com.edutools.tesigoapp.Repositories;

import com.edutools.tesigoapp.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
