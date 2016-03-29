package app.ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import app.jpa.entities.User;

@Remote
public interface GestionMAJInformationsRemote {
	
	
	public boolean updateInfo(int idUser ,String Actualite);
	public boolean validationInfo(int idUser);
	public List<User> getMAJInfo(); 
	public boolean ajoutInfo(int idUser ,String Actualite);

}
