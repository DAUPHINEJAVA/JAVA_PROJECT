package app.ejb.interfaces;

import javax.ejb.Remote;

import app.jpa.entities.Contrat;

@Remote
public interface ContratBeanRemote {

	public void creationContrat(Contrat contrat);
}
