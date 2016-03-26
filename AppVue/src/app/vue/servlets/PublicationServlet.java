package app.vue.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.ejb.interfaces.OffreBeanRemote;

/**
 * Servlet implementation class PublicationServelet
 */
@WebServlet("/PublicationServlet")
public class PublicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
       private OffreBeanRemote offreBeanRemote;
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
		processRequest(request,response);
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("test/html;charset=UTF-8");
		request.setAttribute("publications", offreBeanRemote.getIndexPublication());
		//getServletContext().getRequestDispatcher("/PublicationTest.jsp").forward(request, response);
		System.out.println(offreBeanRemote.getIndexPublication().get(0).getActualite());
	}

}
