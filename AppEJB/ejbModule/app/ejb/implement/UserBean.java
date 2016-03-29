package app.ejb.implement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import app.ejb.DAO.PublicationJpaController;
import app.ejb.interfaces.OffreBeanRemote;
import app.ejb.interfaces.UserBeanRemote;
import app.jpa.entities.Publication;
import app.jpa.entities.User;
import app.ejb.DAO.UserJpaController;
/**
 * Session Bean implementation class OffreBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserBean implements UserBeanRemote {


	    @Resource
	    private EJBContext context;    
	    @PersistenceUnit(unitName="AppJPA")
	    private EntityManagerFactory emf;
	    private UserJpaController userJpaController;
    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    @Override
	public Boolean checkUser(String email, String passwd){
		User user = userJpaController.findUtilisateurByMail(email);
		if(user != null && user.getMdp().equals(passwd))
			return true;
		else 
			return false;
	}
	@Override
	public void creationUser(User user) {
		//userJpaController.create(user);
		
	}
		

	
}