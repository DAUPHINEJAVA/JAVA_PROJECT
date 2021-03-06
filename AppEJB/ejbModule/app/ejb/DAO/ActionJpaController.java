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
import app.jpa.entities.Action;
import app.jpa.entities.MembreSociete;
import app.jpa.entities.Publication;

public class ActionJpaController {

	public ActionJpaController(UserTransaction utx, EntityManagerFactory emf) {
		this.utx = utx;
		this.emf = emf;
	}

	private UserTransaction utx = null;
	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public List<Action> findAllAction(int maxResults) {
		EntityManager em = getEntityManager();
		String query = "SELECT a FROM Action a";
		try {
			Query q = em.createQuery(query);
			q.setMaxResults(maxResults);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public void create(Action action) throws RollbackFailureException,
			Exception {

		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			em.persist(action);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception re) {
				throw new RollbackFailureException(
						"An error occurred attempting to roll back the transaction.",
						re);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Action action) throws NonexistentEntityException,
			RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			Action persistentAction = em.find(Action.class,
					action.getIdContrat());

			List<Action> allAction = findActionEntities();

			for (Action ActionListToAttach : allAction) {

				if (action.getIdContrat() == action.getIdContrat()) {

					destroy(action.getIdContrat());
					create(action);

				}
			}
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception re) {
				throw new RollbackFailureException(
						"An error occurred attempting to roll back the transaction.",
						re);
			}
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				int id = action.getIdContrat();
				if (findAction(id) == null) {
					throw new NonexistentEntityException("The Action with id "
							+ id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(int id) throws NonexistentEntityException,
			RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			Action action;
			try {
				action = em.getReference(Action.class, id);
				action.getIdContrat();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The Action with id " + id
						+ " no longer exists.", enfe);
			}

			em.remove(action);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception re) {
				throw new RollbackFailureException(
						"An error occurred attempting to roll back the transaction.",
						re);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Action> findActionEntities() {
		return findActionEntities(true, -1, -1);
	}

	public List<Action> findMembreSocieteEntities(int maxResults,
			int firstResult) {
		return findActionEntities(false, maxResults, firstResult);
	}

	private List<Action> findActionEntities(boolean all, int maxResults,
			int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Action.class));
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

	public Action findAction(int id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Action.class, id);
		} finally {
			em.close();
		}
	}

}
