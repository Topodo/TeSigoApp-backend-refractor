package com.edutools.tesigoapp.rest;

import com.edutools.tesigoapp.entities.Course;
import com.edutools.tesigoapp.entities.User;
import com.edutools.tesigoapp.repositories.CourseRepository;
import com.edutools.tesigoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/users")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    // GET Method that returns all Users in the database
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }

    // GET Method that returns all courses of an user
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/courses")
    @ResponseBody
    public Iterable<Course> getCourses(@PathVariable("id") Integer userId, @RequestParam(required = false) String sort) {
        if (this.userRepository.findById(userId).isPresent()) {
            User user = this.userRepository.findById(userId).get();
            if (sort != null) {
                switch (sort) {
                    case "asc":
                        return this.courseRepository.findCourseByUsersOrderByNameAsc(user);
                    case "desc":
                        return this.courseRepository.findCourseByUsersOrderByNameDesc(user);
                }
            } else {
                return user.getCourses();
            }
        }
        throw new ResourceNotFoundException("User not found.");
    }

    // POST Method that creates a new User if the current User had the Administrator permissions
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@RequestBody User user, @RequestParam(value = "current_user_id") Integer id) {
        Optional<User> currentUser = this.userRepository.findById(id);
        if (currentUser.isPresent() && currentUser.get().getRole().equals("admin")) {
            return this.userRepository.save(user);
        }
        throw new ResourceNotFoundException("User not found.");
    }
}
