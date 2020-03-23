package com.edutools.tesigoapp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "evaluation_indicator")
public class EvaluationIndicator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "learning_objective_id")
    @JsonBackReference(value = "objective-indicator")
    @JsonIgnore
    private LearningObjective learningObjective;

    @OneToMany(mappedBy = "evaluationIndicator")
    @JsonManagedReference(value = "indicator-status")
    @JsonIgnore
    private Set<EvaluationIndicatorStatus> evaluationIndicatorStatuses;


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

    public LearningObjective getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(LearningObjective learningObjective) {
        this.learningObjective = learningObjective;
    }

    public Set<EvaluationIndicatorStatus> getEvaluationIndicatorStatuses() {
        return evaluationIndicatorStatuses;
    }

    public void setEvaluationIndicatorStatuses(Set<EvaluationIndicatorStatus> evaluationIndicatorStatuses) {
        this.evaluationIndicatorStatuses = evaluationIndicatorStatuses;
    }
}
