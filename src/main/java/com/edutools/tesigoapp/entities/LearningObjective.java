package com.edutools.tesigoapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "learning_objective")
public class LearningObjective implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonBackReference(value = "subject-objective")
    @JsonIgnore
    private Subject subject;

    @OneToMany(mappedBy = "learningObjective")
    @JsonManagedReference(value = "objective-indicator")
    @JsonIgnore
    private Set<EvaluationIndicator> evaluationIndicators = new HashSet<>();

    @OneToMany(mappedBy = "learningObjective")
    @JsonManagedReference(value = "objective-status")
    @JsonIgnore
    private Set<LearningObjectiveStatus> learningObjectiveStatuses = new HashSet<>();


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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<EvaluationIndicator> getEvaluationIndicators() {
        return evaluationIndicators;
    }

    public void setEvaluationIndicators(Set<EvaluationIndicator> evaluationIndicators) {
        this.evaluationIndicators = evaluationIndicators;
    }

    public Set<LearningObjectiveStatus> getLearningObjectiveStatuses() {
        return learningObjectiveStatuses;
    }

    public void setLearningObjectiveStatuses(Set<LearningObjectiveStatus> learningObjectiveStatuses) {
        this.learningObjectiveStatuses = learningObjectiveStatuses;
    }
}
