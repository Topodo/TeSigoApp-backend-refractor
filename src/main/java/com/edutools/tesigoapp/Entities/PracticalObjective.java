package com.edutools.tesigoapp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "practical_objective")
public class PracticalObjective implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "student-practical-objective")
    @JsonIgnore
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qualitative_evidence_form_id", referencedColumnName = "id")
    private QualitativeEvidenceForm qualitativeEvidenceForm;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public QualitativeEvidenceForm getQualitativeEvidenceForm() {
        return qualitativeEvidenceForm;
    }

    public void setQualitativeEvidenceForm(QualitativeEvidenceForm qualitativeEvidenceForm) {
        this.qualitativeEvidenceForm = qualitativeEvidenceForm;
    }
}
