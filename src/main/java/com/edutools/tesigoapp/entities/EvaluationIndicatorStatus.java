package com.edutools.tesigoapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "evaluation_indicator_status")
@JsonIgnoreProperties({"evaluationIndicator", "student"})
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
    private Timestamp date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationIndicatorStatus that = (EvaluationIndicatorStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(status, that.status) &&
                Objects.equals(evaluationIndicatorId, that.evaluationIndicatorId) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(evaluationIndicator, that.evaluationIndicator) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, evaluationIndicatorId, studentId, date, evaluationIndicator, student);
    }
}
