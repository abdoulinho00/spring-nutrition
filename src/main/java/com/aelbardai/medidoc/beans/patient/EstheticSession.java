package com.aelbardai.medidoc.beans.patient;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="esthetic_session")
public class EstheticSession {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    private String observations;
    
    private String facePath;
    private String rightProfilePath;
    private String leftProfilePath;
    
    @ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name="esthetic_visit_id")
    private EstheticVisit estheticVisit;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
    public EstheticVisit getEstheticVisit() {
        return estheticVisit;
    }
    public void setEstheticVisit(EstheticVisit estheticVisit) {
        this.estheticVisit = estheticVisit;
    }
    public String getFacePath() {
        return facePath;
    }
    public void setFacePath(String facePath) {
        this.facePath = facePath;
    }
    public String getRightProfilePath() {
        return rightProfilePath;
    }
    public void setRightProfilePath(String rightProfilePath) {
        this.rightProfilePath = rightProfilePath;
    }
    public String getLeftProfilePath() {
        return leftProfilePath;
    }
    public void setLeftProfilePath(String leftProfilePath) {
        this.leftProfilePath = leftProfilePath;
    }
    
}
