package com.edutools.tesigoapp.repositories;

import com.edutools.tesigoapp.entities.Course;
import com.edutools.tesigoapp.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Iterable <Course> findCourseByUsersOrderByNameAsc(User user);
    Iterable <Course> findCourseByUsersOrderByNameDesc(User user);
}
