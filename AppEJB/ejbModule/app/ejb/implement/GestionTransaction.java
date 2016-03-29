package app.ejb.implement;

import app.ejb.DAO.ContratJpaController;
import app.ejb.DAO.exceptions.NonexistentEntityException;
import app.ejb.DAO.exceptions.RollbackFailureException;
import app.ejb.interfaces.GestionTransactionRemote;
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
 * Session Bean implementation class GestionTransaction
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)

public class GestionTransaction implements GestionTransactionRemote {

	@Resource
	private EJBContext context;
	@PersistenceUnit(unitName = "AppJPA")
	private EntityManagerFactory emf;
	
    public GestionTransaction() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void achatContratImmediat(int numero) {
		// TODO Auto-generated method stub
		ContratJpaController contratDAO = new ContratJpaController(context.getUserTransaction(),emf);
    	Contrat contrat = contratDAO.findContrat(numero);
    	contrat.setEtat(1);
    	try {
			contratDAO.edit(contrat);
		} catch (NonexistentEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void achatContratEncheres(int numero) {
		// TODO Auto-generated method stub
		ContratJpaController contratDAO = new ContratJpaController(context.getUserTransaction(),emf);
    	Contrat contrat = contratDAO.findContrat(numero);
    	contrat.setEtat(1);
    	try {
			contratDAO.edit(contrat);
		} catch (NonexistentEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}

	@Override
	public void miseEnVente(int numero, float montant, String typeVente) {
		// TODO Auto-generated method stub
		ContratJpaController contratDAO = new ContratJpaController(context.getUserTransaction(),emf);
		Contrat contrat = contratDAO.findContrat(numero);
		contrat.setEtat(0);
		contrat.setMontat(montant);
		if(typeVente.equals("immediat")){
			contrat.setType(0);
		}else{ if(typeVente.equals("encheres")){
		contrat.setType(0);
		}
		}
		
		try {
			contratDAO.edit(contrat);
		} catch (NonexistentEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajoutContrat(Contrat contrat) {
	    	
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
