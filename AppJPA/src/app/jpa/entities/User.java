package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private int idUser;

	private String login;

	private String mail;

	private String mdp;

	private String nom;

	private String prenom;

	private int role;

	private String tel;

	//bi-directional many-to-one association to Contrat
	@OneToMany(mappedBy="user")
	private List<Contrat> contrats;

	//bi-directional one-to-one association to MembreSociete
	@OneToOne(mappedBy="user")
	private MembreSociete membreSociete;

	//bi-directional many-to-one association to Publication
	@OneToMany(mappedBy="user")
	private List<Publication> publications;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat addContrat(Contrat contrat) {
		getContrats().add(contrat);
		contrat.setUser(this);

		return contrat;
	}

	public Contrat removeContrat(Contrat contrat) {
		getContrats().remove(contrat);
		contrat.setUser(null);

		return contrat;
	}

	public MembreSociete getMembreSociete() {
		return this.membreSociete;
	}

	public void setMembreSociete(MembreSociete membreSociete) {
		this.membreSociete = membreSociete;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication addPublication(Publication publication) {
		getPublications().add(publication);
		publication.setUser(this);

		return publication;
	}

	public Publication removePublication(Publication publication) {
		getPublications().remove(publication);
		publication.setUser(null);

		return publication;
	}

}