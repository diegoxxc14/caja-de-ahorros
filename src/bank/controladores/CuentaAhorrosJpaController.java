/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controladores;

import bank.controladores.exceptions.NonexistentEntityException;
import bank.modelos.CuentaAhorros;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Diego Cuenca
 */
public class CuentaAhorrosJpaController implements Serializable {

    public CuentaAhorrosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CuentaAhorros cuentaAhorros) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cuentaAhorros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CuentaAhorros cuentaAhorros) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cuentaAhorros = em.merge(cuentaAhorros);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cuentaAhorros.getId();
                if (findCuentaAhorros(id) == null) {
                    throw new NonexistentEntityException("The cuentaAhorros with id " + id + " no longer exists.");
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
            CuentaAhorros cuentaAhorros;
            try {
                cuentaAhorros = em.getReference(CuentaAhorros.class, id);
                cuentaAhorros.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuentaAhorros with id " + id + " no longer exists.", enfe);
            }
            em.remove(cuentaAhorros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CuentaAhorros> findCuentaAhorrosEntities() {
        return findCuentaAhorrosEntities(true, -1, -1);
    }

    public List<CuentaAhorros> findCuentaAhorrosEntities(int maxResults, int firstResult) {
        return findCuentaAhorrosEntities(false, maxResults, firstResult);
    }

    private List<CuentaAhorros> findCuentaAhorrosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CuentaAhorros.class));
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

    public CuentaAhorros findCuentaAhorros(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CuentaAhorros.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuentaAhorrosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CuentaAhorros> rt = cq.from(CuentaAhorros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
