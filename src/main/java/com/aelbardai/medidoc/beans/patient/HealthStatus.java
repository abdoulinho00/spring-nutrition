package com.aelbardai.medidoc.beans.patient;

import java.io.Serializable;

public class HealthStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6520430964666049105L;
	private long id;
	private float height;
	private float weight;
	private short bloodPressure;
	private short sugarRate;
	private short heartBeat;
	
	private HealthStatus(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
