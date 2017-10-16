package com.SBB.aervice;

import com.SBB.entity.AngebotPO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.lang.Exception;
import javax.persistence.*;
import java.util.List;

@Service
public class AngebotServiceImpl implements AngebotService {
    public EntityManager em = Persistence.createEntityManagerFactory("SBB").createEntityManager();
    /*private long Id;
    private long Reisender;
    private long Zug;
    private String Bemerkung;*/

    public AngebotPO addAngebot(AngebotPO angebotPO) throws Exception {
        try {
            em.getTransaction().begin();
            AngebotPO angebotFromDB = em.merge(angebotPO);
            em.getTransaction().commit();
            return angebotFromDB;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("DB-Error: Error by creating Angebot");
        }
    }

    public AngebotPO get(long id) {
        return em.find(AngebotPO.class, id);
    }

    public void deleteAngebot(long id) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(get(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("DB-Error: Error by deleteing Angebot");
        }
    }

    public List<AngebotPO> getAll() {
        Query NamedQuery = em.createNamedQuery("Angebot.getAll");
        return NamedQuery.getResultList();
    }
}
