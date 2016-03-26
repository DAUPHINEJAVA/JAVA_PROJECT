package app.ejb.DAO.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * IllegalOrphanException 
 * 
 * @author dac
 */
public class IllegalOrphanException extends Exception {
    private List<String> messages;
            
    /**
     * IllegalOrphanException() constructeur de la classe.
     * 
     * @param messages : liste de messages à aficher
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }
    
    /**
     * getMessages() permet de récupérer les messages de l'erreur.
     * 
     * @return une liste de String contenant les messages
     */
    public List<String> getMessages() {
        return messages;
    }
}
