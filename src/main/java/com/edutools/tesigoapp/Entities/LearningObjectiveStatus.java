package com.edutools.tesigoapp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "learning_objective_status")
public class LearningObjectiveStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "learning_objective_id")
    private Integer learningObjectiveId;

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "Date")
    private java.sql.Timestamp date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "learning_objective_id")
    @JsonBackReference(value = "objective-status")
    @JsonIgnore
    private LearningObjective learningObjective;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "student-objective-status")
    @JsonIgnore
    private Student student;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLearningObjectiveId() {
        return this.learningObjectiveId;
    }

    public void setLearningObjectiveId(Integer learningObjectiveId) {
        this.learningObjectiveId = learningObjectiveId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public java.sql.Timestamp getDate() {
        return this.date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public LearningObjective getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(LearningObjective learningObjective) {
        this.learningObjective = learningObjective;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
