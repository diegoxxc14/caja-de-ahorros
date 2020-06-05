package bank.controladores;

import bank.controladores.exceptions.NonexistentEntityException;
import bank.modelos.Amortizacion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AmortizacionJpaController implements Serializable {

    public AmortizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Amortizacion amortizacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(amortizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Amortizacion amortizacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            amortizacion = em.merge(amortizacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = amortizacion.getId();
                if (findAmortizacion(id) == null) {
                    throw new NonexistentEntityException("The amortizacion with id " + id + " no longer exists.");
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
            Amortizacion amortizacion;
            try {
                amortizacion = em.getReference(Amortizacion.class, id);
                amortizacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The amortizacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(amortizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Amortizacion> findAmortizacionEntities() {
        return findAmortizacionEntities(true, -1, -1);
    }

    public List<Amortizacion> findAmortizacionEntities(int maxResults, int firstResult) {
        return findAmortizacionEntities(false, maxResults, firstResult);
    }

    private List<Amortizacion> findAmortizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Amortizacion.class));
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

    public Amortizacion findAmortizacion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Amortizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAmortizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Amortizacion> rt = cq.from(Amortizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Amortizacion> findAmortizacionByIdCredito(Long credito_id) {
        EntityManager em = getEntityManager();
        TypedQuery<Amortizacion> qAmortizacion = em.createNamedQuery("amortizacion_credito", Amortizacion.class);
        qAmortizacion.setParameter("prmId", credito_id);
        return qAmortizacion.getResultList();
    }
}
