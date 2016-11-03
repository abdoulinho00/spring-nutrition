package com.aelbardai.medidoc.beans.patient;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7982951330048611643L;
	private long id;
	private String reason;
	private String description;
	private HealthStatus status;
	private Date visitTime;
	
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
	
	

}
