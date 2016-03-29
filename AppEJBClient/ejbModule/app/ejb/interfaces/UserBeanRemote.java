package app.ejb.interfaces;

import javax.ejb.Remote;

import app.jpa.entities.Societe;
import app.jpa.entities.User;

@Remote
public interface UserBeanRemote {

	public void creationUser(User user);
	public Boolean checkUser(String email,String passwd);
	
}
