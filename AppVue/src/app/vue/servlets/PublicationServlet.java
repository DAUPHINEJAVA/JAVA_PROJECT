package app.vue.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.jpa.entities.Contrat;
import app.ejb.interfaces.GestionContratBeanRemote;
import app.ejb.interfaces.OffreBeanRemote;

/**
 * Servlet implementation class PublicationServelet
 */
@WebServlet("/PublicationServlet")
public class PublicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
       private OffreBeanRemote offreBeanRemote;
       private GestionContratBeanRemote gestionContratBeanRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//processRequest(request,response);
		Contrat contrat = new Contrat();
	
		
		String type = request.getParameter("type");
		String montant = request.getParameter("montant");
		String client = request.getParameter("client");
		String societe = request.getParameter("societe");
		
		if(type.equals("action")){
			contrat.setType(1);
		}else{
			if(type.equals("titre")){
				contrat.setType(2);
		}}
		 //contrat.setMontat(Integer.parseInt(montant));
		 	
		
		 gestionContratBeanRemote.ajoutContrat(contrat);}
		
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		/* String message = "Transmission de variables : OK !";

		    request.setAttribute( "test", message );

		    this.getServletContext().getRequestDispatcher( "/listPublication.jsp" ).forward( request, response); */
		
		response.setContentType("test/html;charset=UTF-8");
		request.setAttribute("publications", offreBeanRemote.getIndexPublication());
		request.setAttribute("contrats", gestionContratBeanRemote.getallContrat());
		this.getServletContext().getRequestDispatcher("/tables.jsp").forward(request, response);
		System.out.println(offreBeanRemote.getIndexPublication().get(0).getActualite());
	}

}