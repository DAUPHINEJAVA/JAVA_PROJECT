package app.ejb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import app.jpa.entities.Action;
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
	
/*	public void CreateAction(Action action){
		
		EntityManager em = getEntityManager();
		
		
		
		
		
		
	}*/

}
