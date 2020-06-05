/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controladores;

import bank.controladores.exceptions.NonexistentEntityException;
import bank.modelos.Poliza;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Diego Cuenca
 */
public class PolizaJpaController implements Serializable {

    public PolizaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Poliza poliza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(poliza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Poliza poliza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            poliza = em.merge(poliza);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = poliza.getId();
                if (findPoliza(id) == null) {
                    throw new NonexistentEntityException("The poliza with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Poliza poliza;
            try {
                poliza = em.getReference(Poliza.class, id);
                poliza.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The poliza with id " + id + " no longer exists.", enfe);
            }
            em.remove(poliza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Poliza> findPolizaEntities() {
        return findPolizaEntities(true, -1, -1);
    }

    public List<Poliza> findPolizaEntities(int maxResults, int firstResult) {
        return findPolizaEntities(false, maxResults, firstResult);
    }

    private List<Poliza> findPolizaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Poliza.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Poliza findPoliza(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Poliza.class, id);
        } finally {
            em.close();
        }
    }

    public int getPolizaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Poliza> rt = cq.from(Poliza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Poliza> findPolizasByCliente(Long cliente_id) {
        EntityManager em = getEntityManager();
        TypedQuery<Poliza> qCredito = em.createNamedQuery("poliza_cliente", Poliza.class);
        qCredito.setParameter("prmId", cliente_id);
        return qCredito.getResultList();
    }

}
