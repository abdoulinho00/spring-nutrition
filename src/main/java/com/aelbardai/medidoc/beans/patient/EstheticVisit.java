package com.aelbardai.medidoc.beans.patient;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="esthetic_visit")
public class EstheticVisit {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String identity;
    private String reason;
    private String allergiqueHistory;
    private String dermatologiqueHistory;
    private String estheticTreatmentHistory;
    
    private String classification;
    private String dermatologiqueExamination;
    private String proposedProtocol;
    private String estheticCondition;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date visitDate;
    private String observations;
    
    @OneToMany(mappedBy="estheticVisit",
            fetch=FetchType.LAZY ,cascade = {CascadeType.ALL})
    @OrderBy("date ASC")
    private List<EstheticSession> sessions;
    
    
    
    
    @ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getIdentity() {
        return identity;
    }


    public void setIdentity(String identity) {
        this.identity = identity;
    }


    public String getReason() {
        return reason;
    }


    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getAllergiqueHistory() {
        return allergiqueHistory;
    }


    public void setAllergiqueHistory(String allergiqueHistory) {
        this.allergiqueHistory = allergiqueHistory;
    }


    public String getDermatologiqueHistory() {
        return dermatologiqueHistory;
    }


    public void setDermatologiqueHistory(String dermatologiqueHistory) {
        this.dermatologiqueHistory = dermatologiqueHistory;
    }


    public String getEstheticTreatmentHistory() {
        return estheticTreatmentHistory;
    }


    public void setEstheticTreatmentHistory(String estheticTreatmentHistory) {
        this.estheticTreatmentHistory = estheticTreatmentHistory;
    }


    public String getClassification() {
        return classification;
    }


    public void setClassification(String classification) {
        this.classification = classification;
    }


    public String getDermatologiqueExamination() {
        return dermatologiqueExamination;
    }


    public void setDermatologiqueExamination(String dermatologiqueExamination) {
        this.dermatologiqueExamination = dermatologiqueExamination;
    }


    public String getProposedProtocol() {
        return proposedProtocol;
    }


    public void setProposedProtocol(String proposedProtocol) {
        this.proposedProtocol = proposedProtocol;
    }

    public String getEstheticCondition() {
        return estheticCondition;
    }


    public void setEstheticCondition(String estheticCondition) {
        this.estheticCondition = estheticCondition;
    }


    public Date getVisitDate() {
        return visitDate;
    }


    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }


    public String getObservations() {
        return observations;
    }


    public void setObservations(String observations) {
        this.observations = observations;
    }


    public List<EstheticSession> getSessions() {
        return sessions;
    }


    public void setSessions(List<EstheticSession> sessions) {
        this.sessions = sessions;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
 
        
}
