package com.edutools.tesigoapp.rest;

import com.edutools.tesigoapp.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subjects")
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;



}
