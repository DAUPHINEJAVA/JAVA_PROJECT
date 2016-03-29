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
import app.jpa.entities.Publication;

public class PublicationJpaController {

	  public PublicationJpaController(UserTransaction utx, EntityManagerFactory emf) {
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
	
    public List<Publication> findIndexPublication(int maxResults) {
        EntityManager em = getEntityManager();
        String query = "SELECT p FROM Publication p";
        try {
            Query q = em.createQuery(query);
            q.setMaxResults(maxResults);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    

	public void create(Publication publication) throws RollbackFailureException, Exception {

		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			em.persist(publication);
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

	public void edit(Publication publication)
			throws NonexistentEntityException, RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			utx.begin();
			em = getEntityManager();
			Publication persistentPublication = em.find(Publication.class, publication.getIdPub());

			List<Publication> allPublication = findPublicationEntities();

			for (Publication PublicationListToAttach : allPublication) {

				if (publication.getIdPub() == publication.getIdPub()) {

					destroy(publication.getIdPub());
					create(publication);

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
				int id = publication.getIdPub();
				if (findPublication(id) == null) {
					throw new NonexistentEntityException("The Publication with id " + id + " no longer exists.");
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
			Publication publication;
			try {
				publication = em.getReference(Publication.class, id);
				publication.getDatePub();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The Publication with id " + id + " no longer exists.", enfe);
			}

			em.remove(publication);
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

	public List<Publication> findPublicationEntities() {
		return findPublicationEntities(true, -1, -1);
	}

	public List<Publication> findPublicationEntities(int maxResults, int firstResult) {
		return findPublicationEntities(false, maxResults, firstResult);
	}

	private List<Publication> findPublicationEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Publication.class));
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

	public Publication findPublication(int id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Publication.class, id);
		} finally {
			em.close();
		}
	}
}
