package assign.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;

/**
 * Servlet implementation class for Servlet: GetEmailAddresswithAjax
 *
 */
 public class GetEmailAddresswithAjax extends jakarta.servlet.http.HttpServlet implements jakarta.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the email address
		//set to session
		String emailID = request.getParameter("emailid");
		System.out.println("Email ID got from client: " + emailID);
		EMailBO eMailBO = new EMailBO();
		EMailAddressVOO emailvo = null;
		try{
			emailvo = eMailBO.getEMailAddress(emailID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("emailobject", emailvo);
			response.sendRedirect("/mysite/ajaxoutput.jsp");
	}  		
}