package com.aelbardai.medidoc.beans.patient;

import java.io.Serializable;
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
@Table(name="visit")
public class Visit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7982951330048611643L;
	
	/*
	 * Visit attributes
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String reason;
	private String description;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date visitTime;
	/*
	 * Health status attributes
	 */
	private float height;
	private float weight;
	private short bloodPressure;
	private short sugarRate;
	private short heartBeat;
	/*
	 *  path to image file
	 */
	private String beforePath;
	private String afterPath;
	/*
	 * Attached patient
	 */
	@ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name="patient_id")
	private Patient patient;
	
	public Visit(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public short getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(short bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public short getSugarRate() {
		return sugarRate;
	}

	public void setSugarRate(short sugarRate) {
		this.sugarRate = sugarRate;
	}

	public short getHeartBeat() {
		return heartBeat;
	}

	public void setHeartBeat(short heartBeat) {
		this.heartBeat = heartBeat;
	}

    public String getBeforePath() {
        return beforePath;
    }

    public void setBeforePath(String beforePath) {
        this.beforePath = beforePath;
    }

    public String getAfterPath() {
        return afterPath;
    }

    public void setAfterPath(String afterPath) {
        this.afterPath = afterPath;
    }
	
	

}
