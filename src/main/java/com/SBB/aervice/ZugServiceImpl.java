package com.SBB.aervice;

import com.SBB.entity.ZugPO;

import javax.persistence.*;
import java.util.List;

public class ZugServiceImpl implements ZugService {
    public EntityManager em = Persistence.createEntityManagerFactory("SBB").createEntityManager();

    public ZugPO get(long id) {
        return em.find(ZugPO.class, id);
    }

    public ZugPO add(ZugPO zugPO) {
        em.getTransaction().begin();
        ZugPO zug = em.merge(zugPO);
        em.getTransaction().commit();
        return zug;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(ZugPO zugPO) {
        em.getTransaction().begin();
        em.merge(zugPO);
        em.getTransaction().commit();
    }

    public List<ZugPO> getAll() {
        Query NamedQuery = em.createNamedQuery("Zug.getAll");
        return NamedQuery.getResultList();
    }

}
