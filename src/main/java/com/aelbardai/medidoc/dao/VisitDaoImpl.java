package com.aelbardai.medidoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.aelbardai.medidoc.beans.patient.Visit;

@Repository
public class VisitDaoImpl implements VisitDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Visit getVisitById(long id) {
		
		return entityManager.find(Visit.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getAllVisit() {
		return entityManager.createQuery("select visit from Visit visit ").getResultList();
	}

	@Override
	public Visit addVisit(Visit visit) {
		entityManager.persist(visit);
		return visit;
	}

	@Override
	public Visit updateVisit(Visit visit) {
		entityManager.merge(visit);
		return visit;
	}


	@Override
	public void deleteVisit(long id) {
		entityManager.remove(getVisitById(id));
	}

}
