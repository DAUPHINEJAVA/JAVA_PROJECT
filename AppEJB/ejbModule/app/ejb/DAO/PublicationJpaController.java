package app.ejb.DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

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
}
