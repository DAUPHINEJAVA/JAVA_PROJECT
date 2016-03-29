package app.ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GestionRechercheRemote {
	
	public List<Object> findListAllContrat();

}
