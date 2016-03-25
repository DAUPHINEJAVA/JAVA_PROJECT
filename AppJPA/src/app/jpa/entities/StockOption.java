package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the StockOption database table.
 * 
 */
@Entity
@NamedQuery(name="StockOption.findAll", query="SELECT s FROM StockOption s")
public class StockOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_contrat")
	private int idContrat;

	@Temporal(TemporalType.DATE)
	@Column(name="date_maturite")
	private Date dateMaturite;

	@Column(name="prix_initial")
	private double prixInitial;

	//bi-directional one-to-one association to Contrat
	@OneToOne
	@JoinColumn(name="id_contrat")
	private Contrat contrat;

	public StockOption() {
	}

	public int getIdContrat() {
		return this.idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public Date getDateMaturite() {
		return this.dateMaturite;
	}

	public void setDateMaturite(Date dateMaturite) {
		this.dateMaturite = dateMaturite;
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