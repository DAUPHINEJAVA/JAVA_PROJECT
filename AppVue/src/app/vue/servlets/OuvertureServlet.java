
package app.vue.servlets;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ejb.interfaces.UserBeanRemote;
/**
* Servlet implementation class ServletOuvertureSession
*/
@WebServlet("/ServletOuvertureSession")
public class OuvertureServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
@EJB
private UserBeanRemote userBeanRemote;


public OuvertureServlet() {
super();

// TODO Auto-generated constructor stub
}


/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

 response.setContentType("text/html");
 String adrMail = request.getParameter("email_Adr");
 String mdpMail = request.getParameter("motdepasse");
 if(userBeanRemote.checkUser(adrMail,mdpMail) == true){
		if(UserBeanRemote.CheckTypeUser(adrMail) == 1){		
			request.getSession().setAttribute("admin", true);
			//request.getSession().setAttribute("first", true);
			response.sendRedirect("Home.jsp");
		}
		else{ if (UserBeanRemote.checkTypeUser(adrMail) == 2)
		{
			request.getSession().setAttribute("Inverstisseur", true);
			response.sendRedirect("Home.jsp");
		}}}else{ if(MembreSocieteBeanRemote.checkUser(adrMail)){
		request.getSession().setAttribute("MembreSociete", true);
		response.sendRedirect("Home.jsp");
	}
   }
		
	 
 


/**
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
try {
	response.setContentType("text/html");
	PrintWriter printWriter = response.getWriter();
	printWriter.println("<h2>");
	printWriter.println("Hello. Ma 1ère servlet.");
	printWriter.println("</h2>");
     } 
catch (IOException ioException) {
ioException.printStackTrace();
}
*/
}