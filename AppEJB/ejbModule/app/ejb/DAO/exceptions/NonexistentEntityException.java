package app.ejb.DAO.exceptions;

/**
 * NonexistentEntityException est l'exception levée lorsque une entity utilisée 
 * n'existe pas.
 * 
 * @author dac
 */
public class NonexistentEntityException extends Exception {
    
    /**
     * NonexistentEntityException() constructeur de la classe
     * @param message : message a afficher
     * @param cause : cause de l'exception
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * NonexistentEntityException() constructeur de la classe
     * @param message : message a afficher
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
