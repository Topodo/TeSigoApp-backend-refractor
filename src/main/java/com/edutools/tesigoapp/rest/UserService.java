package com.edutools.tesigoapp.rest;

import com.edutools.tesigoapp.Entities.User;
import com.edutools.tesigoapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // GET Method that returns all Users in the database
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }
}
