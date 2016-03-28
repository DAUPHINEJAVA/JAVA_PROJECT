package app.ejb.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import app.ejb.DAO.exceptions.NonexistentEntityException;
import app.ejb.DAO.exceptions.RollbackFailureException;
import app.jpa.entities.Societe;
import app.jpa.entities.StockOption;

public class SocieteJpaController {

	public SocieteJpaController(UserTransaction utx, EntityManagerFactory emf) {
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


	public void create(Societe societe) throws RollbackFailureException, Exception {

		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			em.persist(societe);
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


	public void edit(Societe societe) throws NonexistentEntityException, RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			Societe persistentSociete = em.find(Societe.class, societe.getIdAgence());

			List<Societe> allSociete = findSocieteEntities();

			for (Societe SocieteListToAttach : allSociete) {

				if (SocieteListToAttach.getIdAgence() == societe.getIdAgence()) {

					destroy(societe.getIdAgence());
					create(societe);

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
				int id = societe.getIdAgence();
				if (findSociete(id) == null) {
					throw new NonexistentEntityException("The Societe with id " + id + " no longer exists.");
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
			Societe societe;
			try {
				societe = em.getReference(Societe.class, id);
				societe.getIdAgence();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The Societe with id " + id + " no longer exists.", enfe);
			}

			em.remove(societe);
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


	public List<Societe> findSocieteEntities() {
		return findSocieteEntities(true, -1, -1);
	}


	public List<Societe> findSocieteEntities(int maxResults, int firstResult) {
		return findSocieteEntities(false, maxResults, firstResult);
	}

	private List<Societe> findSocieteEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Societe.class));
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

	public Societe findSociete(int id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Societe.class, id);
		} finally {
			em.close();
		}
	}
	
}
