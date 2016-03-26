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
import app.jpa.entities.Publication;

/**
 * Session Bean implementation class OffreBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class OffreBean implements OffreBeanRemote {


	    @Resource
	    private EJBContext context;    
	    @PersistenceUnit(unitName="AppJPA")
	    private EntityManagerFactory emf;
    /**
     * Default constructor. 
     */
    public OffreBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Publication> getIndexPublication() {
	 
    int max = 20;
         //To change body of generated methods, choose Tools | Templates.
	PublicationJpaController publicationDAO = new PublicationJpaController(context.getUserTransaction(),emf);
	List<Publication> pub = publicationDAO.findIndexPublication(max);
	return pub;
	}

}
