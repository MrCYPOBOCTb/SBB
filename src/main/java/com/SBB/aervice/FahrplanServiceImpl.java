package com.SBB.aervice;

import com.SBB.entity.FahrplanPO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Service
public class FahrplanServiceImpl implements FahrplanService {
    public EntityManager em = Persistence.createEntityManagerFactory("SBB").createEntityManager();

    public FahrplanPO addFahrplan(FahrplanPO fahrplanPO) {
        em.getTransaction().begin();
        FahrplanPO fahrplanFromDB = em.merge(fahrplanPO);
        em.getTransaction().commit();
        return fahrplanFromDB;
    }
    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }
    public FahrplanPO get(long id) {
        return em.find(FahrplanPO.class, id);
    }
    public void update(FahrplanPO fahrplanPO) {
        em.getTransaction().begin();
        em.merge(fahrplanPO);
        em.getTransaction().commit();
    }

    public List<FahrplanPO> getAll() {
        Query NamedQuery = em.createNamedQuery("Fahrplan.getAll");
        return NamedQuery.getResultList();
    }

}
