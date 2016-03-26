package app.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Publication database table.
 * 
 */
@Entity
@NamedQuery(name="Publication.findAll", query="SELECT p FROM Publication p")
public class Publication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pub")
	private int idPub;

	private String actualite;

	@Temporal(TemporalType.DATE)
	@Column(name="date_pub")
	private Date datePub;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Publication() {
	}

	public int getIdPub() {
		return this.idPub;
	}

	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}

	public String getActualite() {
		return this.actualite;
	}

	public void setActualite(String actualite) {
		this.actualite = actualite;
	}

	public Date getDatePub() {
		return this.datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}