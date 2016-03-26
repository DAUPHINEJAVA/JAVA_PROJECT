package app.ejb.interfaces;

import javax.ejb.Remote;

import app.jpa.entities.Contrat;
import app.jpa.entities.Societe;

@Remote
public interface SocieteBeanRemote {

	public void creationSociete(Societe societe);
}
