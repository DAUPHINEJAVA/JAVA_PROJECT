package app.ejb.DAO.exceptions;


/**
 * PreexistingEntityException.
 * 
 * @author dac
 */
public class PreexistingEntityException extends Exception {
    
    /**
     *  PreexistingEntityException() - contructeur de la classe.
     * 
     * @param message : message à afficher
     * @param cause : cause de l'erreur
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     *  PreexistingEntityException() - constructeur de la classe.
     * 
     * @param message : message à afficher
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
