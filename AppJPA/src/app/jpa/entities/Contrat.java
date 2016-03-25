package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Contrat database table.
 * 
 */
@Entity
@NamedQuery(name="Contrat.findAll", query="SELECT c FROM Contrat c")
public class Contrat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numero;

	private int etat;

	private double montat;

	private int quantite;

	private int type;

	//bi-directional one-to-one association to Action
	@OneToOne(mappedBy="contrat")
	private Action action;

	//bi-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="id_agence")
	private Societe societe;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_client")
	private User user;

	//bi-directional one-to-one association to StockOption
	@OneToOne(mappedBy="contrat")
	private StockOption stockOption;

	public Contrat() {
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getEtat() {
		return this.etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public double getMontat() {
		return this.montat;
	}

	public void setMontat(double montat) {
		this.montat = montat;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Societe getSociete() {
		return this.societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StockOption getStockOption() {
		return this.stockOption;
	}

	public void setStockOption(StockOption stockOption) {
		this.stockOption = stockOption;
	}

}