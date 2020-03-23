package com.edutools.tesigoapp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_names")
    private String lastNames;

    @Column(name = "age")
    private Integer age;

    @Column(name = "photo")
    private String photo;

    @Column(name = "run")
    private String run;

    @Column(name = "emergency_number")
    private String emergencyNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    @JsonBackReference(value = "student-course")
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference(value = "student-objective-status")
    @JsonIgnore
    private Set<LearningObjectiveStatus> learningObjectiveStatuses;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference(value = "student-indicator-status")
    @JsonIgnore
    private Set<EvaluationIndicatorStatus> evaluationIndicatorStatuses;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference(value = "student-report")
    @JsonIgnore
    private Set<Report> reports;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference(value = "student-practical-objective")
    @JsonIgnore
    private Set<PracticalObjective> practicalObjectives;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_special_educational_needs",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "special_educational_need_id") })
    @JsonIgnore
    private Set<SpecialEducationalNeed> specialEducationalNeeds;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNames() {
        return this.lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRun() {
        return this.run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getEmergencyNumber() {
        return this.emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<LearningObjectiveStatus> getLearningObjectiveStatuses() {
        return learningObjectiveStatuses;
    }

    public void setLearningObjectiveStatuses(Set<LearningObjectiveStatus> learningObjectiveStatuses) {
        this.learningObjectiveStatuses = learningObjectiveStatuses;
    }

    public Set<EvaluationIndicatorStatus> getEvaluationIndicatorStatuses() {
        return evaluationIndicatorStatuses;
    }

    public void setEvaluationIndicatorStatuses(Set<EvaluationIndicatorStatus> evaluationIndicatorStatuses) {
        this.evaluationIndicatorStatuses = evaluationIndicatorStatuses;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    public Set<PracticalObjective> getPracticalObjectives() {
        return practicalObjectives;
    }

    public void setPracticalObjectives(Set<PracticalObjective> practicalObjectives) {
        this.practicalObjectives = practicalObjectives;
    }

    public Set<SpecialEducationalNeed> getSpecialEducationalNeeds() {
        return specialEducationalNeeds;
    }

    public void setSpecialEducationalNeeds(Set<SpecialEducationalNeed> specialEducationalNeeds) {
        this.specialEducationalNeeds = specialEducationalNeeds;
    }
}