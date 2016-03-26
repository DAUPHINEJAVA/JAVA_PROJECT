package app.ejb.DAO.exceptions;


/**
 * RollbackFailureException est l'exception levée lorsque un problème survient 
 * lors d'une transaction.
 * 
 * @author dac
 */
public class RollbackFailureException extends Exception {
    
    /**
     * RollbackFailureException() constructeur de la classe
     * @param message : message a afficher
     * @param cause : cause de l'exception
     */
    public RollbackFailureException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * RollbackFailureException() constructeur de la classe
     * @param message : message a afficher
     */
    public RollbackFailureException(String message) {
        super(message);
    }
}
