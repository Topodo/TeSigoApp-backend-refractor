package com.edutools.tesigoapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "learning_objective_status")
@JsonIgnoreProperties({"learningObjective", "student"})
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
    private Timestamp date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearningObjectiveStatus that = (LearningObjectiveStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(learningObjectiveId, that.learningObjectiveId) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(date, that.date) &&
                Objects.equals(learningObjective, that.learningObjective) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, learningObjectiveId, studentId, status, date, learningObjective, student);
    }
}
