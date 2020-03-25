package com.edutools.tesigoapp.rest;

import com.edutools.tesigoapp.entities.Course;
import com.edutools.tesigoapp.entities.User;
import com.edutools.tesigoapp.repositories.CourseRepository;
import com.edutools.tesigoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/courses")
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    // GET Method that returns the information of an course specified by his ID
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Course getCourse(@PathVariable("id") Integer id) {
        if (this.courseRepository.findById(id).isPresent()) {
            return this.courseRepository.findById(id).get();
        }
        throw new ResourceNotFoundException("Course not found.");
    }

    // POST Method that creates a new course and links to an user or a list of users
    @RequestMapping(method = RequestMethod.POST, value = "/user/{user_id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Iterable<Course> create(@RequestBody Course course,
                                   @PathVariable("user_id") Integer userId,
                                   @RequestParam(value = "users_ids", required = false) Integer[] usersIds) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isPresent()) {
            user.get().getCourses().add(course);
            course.getUsers().add(user.get());
            for (Integer id : usersIds) {
                user = this.userRepository.findById(id);
                if (user.isPresent()) {
                    user.get().getCourses().add(course);
                    course.getUsers().add(user.get());
                }
            }
            course.setStudentsCount(0);
            this.courseRepository.save(course);
            return this.courseRepository.findCourseByUsersOrderByNameAsc(this.userRepository.findById(userId).get());
        }
        throw new ResourceNotFoundException("User not found.");
    }
}
