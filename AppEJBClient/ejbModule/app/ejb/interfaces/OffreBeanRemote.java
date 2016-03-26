package app.ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import app.jpa.entities.Publication;

@Remote
public interface OffreBeanRemote {

	List<Publication> getIndexPublication();

}
