package app.ejb.implement;

import java.util.List;

import app.ejb.interfaces.GestionRechercheRemote;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class GestionRecherche
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)

public class GestionRecherche implements GestionRechercheRemote {

	@Resource
	private EJBContext context;
	@PersistenceUnit(unitName = "AppJPA")
	private EntityManagerFactory emf;
	
    public GestionRecherche() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Object> findListAllContrat() {
		// TODO Auto-generated method stub
		return null;
	}

}
