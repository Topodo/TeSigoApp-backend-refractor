package com.edutools.tesigoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "qualitative_evidence_form")
public class QualitativeEvidenceForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer practicalObjectiveId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private java.sql.Timestamp date;

    @Column(name = "evidence_URL")
    private String evidenceUrl;

    @OneToOne(mappedBy = "qualitativeEvidenceForm")
    @JsonIgnore
    private PracticalObjective practicalObjective;


    public Integer getPracticalObjectiveId() {
        return this.practicalObjectiveId;
    }

    public void setPracticalObjectiveId(Integer practicalObjectiveId) {
        this.practicalObjectiveId = practicalObjectiveId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Timestamp getDate() {
        return this.date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public String getEvidenceUrl() {
        return this.evidenceUrl;
    }

    public void setEvidenceUrl(String evidenceUrl) {
        this.evidenceUrl = evidenceUrl;
    }

    public PracticalObjective getPracticalObjective() {
        return practicalObjective;
    }

    public void setPracticalObjective(PracticalObjective practicalObjective) {
        this.practicalObjective = practicalObjective;
    }
}
