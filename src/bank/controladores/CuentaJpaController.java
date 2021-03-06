package bank.controladores;

import bank.controladores.exceptions.NonexistentEntityException;
import bank.modelos.Cuenta;
import bank.modelos.Rol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Diego Cuenca
 */
public class CuentaJpaController implements Serializable {

    public CuentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cuenta cuenta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cuenta cuenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cuenta = em.merge(cuenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cuenta.getId();
                if (findCuenta(id) == null) {
                    throw new NonexistentEntityException("The cuenta with id " + id + " no longer exists.");
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
            Cuenta cuenta;
            try {
                cuenta = em.getReference(Cuenta.class, id);
                cuenta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuenta with id " + id + " no longer exists.", enfe);
            }
            em.remove(cuenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cuenta> findCuentaEntities() {
        return findCuentaEntities(true, -1, -1);
    }

    public List<Cuenta> findCuentaEntities(int maxResults, int firstResult) {
        return findCuentaEntities(false, maxResults, firstResult);
    }

    private List<Cuenta> findCuentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cuenta.class));
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

    public Cuenta findCuenta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cuenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cuenta> rt = cq.from(Cuenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Cuenta findByUser(String username) {
        Cuenta cuenta = null;
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Cuenta> consRol = em.createNamedQuery("username_cuenta", Cuenta.class);
            consRol.setParameter("prmUsername", username);
            cuenta = consRol.getSingleResult();
        } catch (NoResultException ex) {
            System.err.println("->" + ex);
        }
        return cuenta;
    }

        public Cuenta findByIdUsuario(long id_usuario) {
        Cuenta cuenta = null;
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Cuenta> consRol = em.createNamedQuery("cuenta_usuario", Cuenta.class);
            consRol.setParameter("prmIdUsuario", id_usuario);
            cuenta = consRol.getSingleResult();
        } catch (NoResultException ex) {
            System.err.println("->" + ex);
        }
        return cuenta;
    }
        
    public List<Cuenta> findAllByCed(String cedCli) {
        EntityManager em = getEntityManager();
        TypedQuery<Cuenta> consIns = em.createNamedQuery("cuenta_cedula", Cuenta.class);
        consIns.setParameter("prmCedula", cedCli);
        return consIns.getResultList();
    }

    public List<Cuenta> findAllByUsername(String username) {
        EntityManager em = getEntityManager();
        TypedQuery<Cuenta> consIns = em.createNamedQuery("cuenta_username", Cuenta.class);
        consIns.setParameter("prmUsername", username);
        return consIns.getResultList();
    }
}
