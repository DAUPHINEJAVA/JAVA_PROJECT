package app.ejb.implement;

import java.util.List;

import app.ejb.DAO.ContratJpaController;
import app.ejb.DAO.PublicationJpaController;
import app.ejb.interfaces.GestionMAJInformationsRemote;
import app.jpa.entities.Contrat;
import app.jpa.entities.Publication;
import app.jpa.entities.User;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class GestionMAJInformations
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class GestionMAJInformations implements GestionMAJInformationsRemote {

    
	@Resource
	private EJBContext context;
	@PersistenceUnit(unitName = "AppJPA")
	private EntityManagerFactory emf;
	
    public GestionMAJInformations() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean updateInfo(int idUser, String Actualite) {
		// TODO Auto-generated method stub
		
		PublicationJpaController publicationDAO = new PublicationJpaController(context.getUserTransaction(),emf);
    //	Publication publication = publicationDAO.
		
		
		return false;
	}

	@Override
	public boolean validationInfo(int idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getMAJInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ajoutInfo(int idUser, String Actualite) {
		// TODO Auto-generated method stub
		return false;
	}

}
