package app.ejb.implement;

import java.util.List;

import app.ejb.DAO.*;
import app.ejb.DAO.exceptions.RollbackFailureException;
import app.ejb.interfaces.GestionContratBeanRemote;
import app.jpa.entities.Contrat;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class GestionContratBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class GestionContratBean implements GestionContratBeanRemote {
	

    @Resource
    private EJBContext context;    
    @PersistenceUnit(unitName="AppJPA")
    private EntityManagerFactory emf;

    /**
     * Default constructor. 
     */
    public GestionContratBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
	public List<Contrat> getallContrat() {
	 
    int max = 20;
         //To change body of generated methods, choose Tools | Templates.
	ContratJpaController contratDAO = new ContratJpaController(context.getUserTransaction(),emf);
	List<Contrat> contrats = contratDAO.findContratEntities();
	return contrats;
	}

    public void ajoutContrat(Contrat contrat){
    	
    	ContratJpaController contratDAO = new ContratJpaController(context.getUserTransaction(),emf);
    	
    	try {
			contratDAO.create(contrat);
		} catch (RollbackFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}
