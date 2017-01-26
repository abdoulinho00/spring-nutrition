package com.aelbardai.medidoc.beans.patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="patient")
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6120632182834458834L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String fullname;
	private String email;
	private String phoneNumber;
	private String adress;
	private String gender;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Transient
	private int age;
	private String profession;
	private String identification;
	private String allergies;
	private float maxWeight;
	private float minWeight;
	private float goodWeight;
	private float maxIMC;
	private float minIMC;
	private float goodIMC;
	@Column(name="personal_history")
	private String personalHistory;
	@Column(name="family_history")
	private String familyHistory;
	private String taste;
	private String water;
	private String treatment;
	private String observations;
	@Column(name="physical_activity")
	private String physicalActivity;
	@OneToMany(mappedBy="patient",
		       fetch=FetchType.EAGER ,cascade = {CascadeType.ALL})
	@OrderBy("visitTime DESC")
	private List<Visit> visits;
	
	private String picturePath;

	public Patient() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		if(birthday!=null){
			
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public float getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(float minWeight) {
		this.minWeight = minWeight;
	}

	public float getGoodWeight() {
		return goodWeight;
	}

	public void setGoodWeight(float goodWeight) {
		this.goodWeight = goodWeight;
	}



	public float getMaxIMC() {
		return maxIMC;
	}

	public void setMaxIMC(float maxIMC) {
		this.maxIMC = maxIMC;
	}

	public float getMinIMC() {
		return minIMC;
	}

	public void setMinIMC(float minIMC) {
		this.minIMC = minIMC;
	}

	public float getGoodIMC() {
		return goodIMC;
	}

	public void setGoodIMC(float goodIMC) {
		this.goodIMC = goodIMC;
	}

	public String getPersonalHistory() {
		return personalHistory;
	}

	public void setPersonalHistory(String personalHistory) {
		this.personalHistory = personalHistory;
	}

	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(String physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public List<Visit> getVisits() {
		if(visits== null) setVisits(new ArrayList<Visit>());
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

	
	

	
}
