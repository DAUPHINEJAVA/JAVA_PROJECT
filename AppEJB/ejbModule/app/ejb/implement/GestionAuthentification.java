package app.ejb.implement;

import app.ejb.interfaces.GestionAuthentificationRemote;
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
 * Session Bean implementation class GestionAuthentification
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)

public class GestionAuthentification implements GestionAuthentificationRemote {

	@Resource
	private EJBContext context;
	@PersistenceUnit(unitName = "AppJPA")
	private EntityManagerFactory emf;

	public GestionAuthentification() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean signIn(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signUp(String mail, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validationMemberSociete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ajoutMemberSociete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
