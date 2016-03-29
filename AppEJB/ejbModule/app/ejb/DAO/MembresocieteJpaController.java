package app.ejb.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;

import app.ejb.DAO.exceptions.NonexistentEntityException;
import app.ejb.DAO.exceptions.RollbackFailureException;
import app.jpa.entities.MembreSociete;
import app.jpa.entities.StockOption;

public class MembresocieteJpaController {
	
	
	 public MembresocieteJpaController(UserTransaction utx, EntityManagerFactory emf) {
	        this.utx = utx;
	        this.emf = emf;
	    }
	    private UserTransaction utx = null;
	    private EntityManagerFactory emf = null;

	    /**
	     * getEntityManager() permet de cr�er une EntityManager.
	     * 
	     * @return 
	     */
	    public EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }

	public void create(MembreSociete membreSociete) throws RollbackFailureException, Exception {

		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			em.persist(membreSociete);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception re) {
				throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(MembreSociete membreSociete)
			throws NonexistentEntityException, RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			MembreSociete persistentMembreSociete = em.find(MembreSociete.class, membreSociete.getIdUser());

			List<MembreSociete> allMembreSociete = findMembreSocieteEntities();

			for (MembreSociete MembreSocieteListToAttach : allMembreSociete) {

				if (membreSociete.getIdUser() == membreSociete.getIdUser()) {

					destroy(membreSociete.getIdUser());
					create(membreSociete);

				}
			}
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception re) {
				throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
			}
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				int id = membreSociete.getIdUser();
				if (findMembreSociete(id) == null) {
					throw new NonexistentEntityException("The MembreSociete with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			MembreSociete membreSociete;
			try {
				membreSociete = em.getReference(MembreSociete.class, id);
				membreSociete.getIdUser();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The MembreSociete with id " + id + " no longer exists.", enfe);
			}

			em.remove(membreSociete);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception re) {
				throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<MembreSociete> findMembreSocieteEntities() {
		return findMembreSocieteEntities(true, -1, -1);
	}

	public List<MembreSociete> findMembreSocieteEntities(int maxResults, int firstResult) {
		return findMembreSocieteEntities(false, maxResults, firstResult);
	}

	private List<MembreSociete> findMembreSocieteEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(MembreSociete.class));
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

	public MembreSociete findMembreSociete(int id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(MembreSociete.class, id);
		} finally {
			em.close();
		}
	}
}
