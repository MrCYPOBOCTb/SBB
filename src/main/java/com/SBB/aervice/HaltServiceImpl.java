package com.SBB.aervice;

import com.SBB.entity.HaltestellePO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Service
public class HaltServiceImpl implements HaltService {
    public EntityManager em = Persistence.createEntityManagerFactory("SBB").createEntityManager();

    public HaltestellePO add(HaltestellePO haltestellePO) {
        em.getTransaction().begin();
        HaltestellePO haltFromDB = em.merge(haltestellePO);
        em.getTransaction().commit();
        return haltFromDB;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public HaltestellePO get(long id) {
        return em.find(HaltestellePO.class, id);
    }

    public void update(HaltestellePO haltestellePO) {
        em.getTransaction().begin();
        em.merge(haltestellePO);
        em.getTransaction().commit();
    }

    public List<HaltestellePO> getAll() {
        Query NamedQuery = em.createNamedQuery("Haltestelle.getAll");
        return NamedQuery.getResultList();
    }

}