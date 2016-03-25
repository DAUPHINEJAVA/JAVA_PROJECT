package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Societe database table.
 * 
 */
@Entity
@NamedQuery(name="Societe.findAll", query="SELECT s FROM Societe s")
public class Societe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agence")
	private int idAgence;

	private String adresse;

	@Column(name="chiffre_affaire")
	private double chiffreAffaire;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	//bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy="societe")
	private List<Contrat> contrats;

	//bi-directional many-to-one association to MembreSociete
	@OneToMany(mappedBy="societe")
	private List<MembreSociete> membreSocietes;

	public Societe() {
	}

	public int getIdAgence() {
		return this.idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getChiffreAffaire() {
		return this.chiffreAffaire;
	}

	public void setChiffreAffaire(double chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat addContrat(Contrat contrat) {
		getContrats().add(contrat);
		contrat.setSociete(this);

		return contrat;
	}

	public Contrat removeContrat(Contrat contrat) {
		getContrats().remove(contrat);
		contrat.setSociete(null);

		return contrat;
	}

	public List<MembreSociete> getMembreSocietes() {
		return this.membreSocietes;
	}

	public void setMembreSocietes(List<MembreSociete> membreSocietes) {
		this.membreSocietes = membreSocietes;
	}

	public MembreSociete addMembreSociete(MembreSociete membreSociete) {
		getMembreSocietes().add(membreSociete);
		membreSociete.setSociete(this);

		return membreSociete;
	}

	public MembreSociete removeMembreSociete(MembreSociete membreSociete) {
		getMembreSocietes().remove(membreSociete);
		membreSociete.setSociete(null);

		return membreSociete;
	}

}