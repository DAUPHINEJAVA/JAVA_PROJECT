package app.ejb.interfaces;

import javax.ejb.Remote;

import app.jpa.entities.Contrat;

@Remote
public interface GestionTransactionRemote {
	
	public void achatContratImmediat(int numero);
	public void achatContratEncheres(int numero);
	public void miseEnVente(int numero, float montant, String typeVente);
    public void ajoutContrat(Contrat contrat);
}
