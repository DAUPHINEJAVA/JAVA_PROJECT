package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Action database table.
 * 
 */
@Entity
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_contrat")
	private int idContrat;

	@Column(name="prix_initial")
	private double prixInitial;

	//bi-directional one-to-one association to Contrat
	@OneToOne
	@JoinColumn(name="id_contrat")
	private Contrat contrat;

	public Action() {
	}

	public int getIdContrat() {
		return this.idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public double getPrixInitial() {
		return this.prixInitial;
	}

	public void setPrixInitial(double prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Contrat getContrat() {
		return this.contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

}