package app.ejb.interfaces;

import java.util.List;
import javax.ejb.Remote;
import app.jpa.entities.Contrat;

@Remote
public interface GestionContratBeanRemote {

	List<Contrat> getallContrat();
	public void ajoutContrat(Contrat contrat);

}
