package app.ejb.interfaces;

import javax.ejb.Remote;

import app.jpa.entities.User;

@Remote
public interface GestionAuthentificationRemote {
	
	public boolean signIn(User user);
	public boolean signUp(String mail,String pwd);
	public boolean validationMemberSociete(User user);
	public boolean ajoutMemberSociete(User user);

}
