package com.SBB.aervice;

import com.SBB.entity.HaltestellePO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;
import java.lang.Exception;

@Service
public class HaltServiceImpl implements HaltService {
    public EntityManager em = Persistence.createEntityManagerFactory("SBB").createEntityManager();

    public HaltestellePO add(HaltestellePO haltestellePO) throws Exception {
        try{
        em.getTransaction().begin();
        HaltestellePO haltFromDB = em.merge(haltestellePO);
        em.getTransaction().commit();
        return haltFromDB;
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new Exception("DB-Error: Error by creating new Haltestelle");
        }
    }

    public void delete(long id) {

        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();

    }

    public HaltestellePO get(long id) {
        return em.find(HaltestellePO.class, id);
    }

    public void update(HaltestellePO haltestellePO) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(haltestellePO);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("DB-Error: Error by Updating Haltestelle");
        }
    }

    public List<HaltestellePO> getAll() {
        Query NamedQuery = em.createNamedQuery("Haltestelle.getAll");
        return NamedQuery.getResultList();
    }

    public List<HaltestellePO> getHaltByUic(long uic){
        Query NamedQuery = em.createNamedQuery("Haltestelle.getHaltByUic").setParameter("uic",uic);
        return NamedQuery.getResultList();
    }

}
