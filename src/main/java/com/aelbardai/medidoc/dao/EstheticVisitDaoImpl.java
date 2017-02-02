package com.aelbardai.medidoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aelbardai.medidoc.beans.patient.EstheticSession;
import com.aelbardai.medidoc.beans.patient.EstheticVisit;

@Repository
public class EstheticVisitDaoImpl implements EstheticVisitDao{
    
    @PersistenceContext
    EntityManager entityManager;
    private Log logger = LogFactory.getLog(EstheticVisitDaoImpl.class);
    
    @Override
    public EstheticVisit getEstheticVisitById(long id) {
        
        return entityManager.find(EstheticVisit.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EstheticVisit> getAllEstheticVisit() {
        List<EstheticVisit> visits = entityManager.createQuery("select estheticVisit from EstheticVisit estheticVisit").getResultList();
       logger.info("visits : " +  visits.size());
        return visits;
    }

    @Override
    public EstheticVisit addEstheticVisit(EstheticVisit estheticVisit) {
        for(EstheticSession session : estheticVisit.getSessions()){
            session.setEstheticVisit(estheticVisit);
            entityManager.persist(session);
        }
        entityManager.persist(estheticVisit);
        
        return estheticVisit;
    }

    @Override
    public EstheticVisit updateEstheticVisit(EstheticVisit estheticVisit) {
        return entityManager.merge(estheticVisit);
    }

    @Override
    public void deleteEstheticVisit(EstheticVisit estheticVisit) {
        entityManager.remove(estheticVisit);
        
    }

    @Override
    public void deleteEstheticVisit(long id) {
        entityManager.remove(getEstheticVisitById(id));
        
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EstheticVisit> getEstheticVisitByPatientId(long patientId) {
       
        List<EstheticVisit> visits= entityManager.createQuery("select estheticVisit from EstheticVisit estheticVisit where estheticVisit.patient.id = :patientId").setParameter("patientId", patientId).getResultList();
        for(EstheticVisit visit : visits){
            visit.setSessions(entityManager.createQuery("select session from EstheticSession session where session.estheticVisit.id = :visitId order by session.date ASC").setParameter("visitId", visit.getId()).getResultList());
        }
        return visits;
    }

}
