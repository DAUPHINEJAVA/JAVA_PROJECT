package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MembreSociete database table.
 * 
 */
@Entity
@NamedQuery(name="MembreSociete.findAll", query="SELECT m FROM MembreSociete m")
public class MembreSociete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private int idUser;

	//bi-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="id_agence")
	private Societe societe;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id_user")
	private User user;

	public MembreSociete() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

}