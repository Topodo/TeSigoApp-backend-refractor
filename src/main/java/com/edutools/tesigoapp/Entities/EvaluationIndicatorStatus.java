package com.edutools.tesigoapp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "evaluation_indicator_status")
public class EvaluationIndicatorStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private Boolean status;

    @Id
    @Column(name = "evaluation_indicator_id")
    private Integer evaluationIndicatorId;

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "date")
    private java.sql.Timestamp date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "evaluation_indicator_id")
    @JsonBackReference(value = "indicator-status")
    @JsonIgnore
    private EvaluationIndicator evaluationIndicator;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "student-indicator-status")
    @JsonIgnore
    private Student student;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getEvaluationIndicatorId() {
        return this.evaluationIndicatorId;
    }

    public void setEvaluationIndicatorId(Integer evaluationIndicatorId) {
        this.evaluationIndicatorId = evaluationIndicatorId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public java.sql.Timestamp getDate() {
        return this.date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public EvaluationIndicator getEvaluationIndicator() {
        return evaluationIndicator;
    }

    public void setEvaluationIndicator(EvaluationIndicator evaluationIndicator) {
        this.evaluationIndicator = evaluationIndicator;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
