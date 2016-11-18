package com.aelbardai.medidoc.beans.patient;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="visit")
public class Visit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7982951330048611643L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String reason;
	private String description;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="health_status_id")
	private HealthStatus status;
	private Date visitTime;
	@ManyToOne
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

	public HealthStatus getStatus() {
		return status;
	}

	public void setStatus(HealthStatus status) {
		this.status = status;
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
	
	

}
