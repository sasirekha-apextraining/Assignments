package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Email Addresses by Group Servlet 
 */

public class GetAllEMailListbyGroupServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
	String groupID = request.getParameter("groupId");
    response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	ArrayList eMailAddress = null;

	try{
	    eMailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		request.getSession().setAttribute("emailList", eMailAddress);
		response.sendRedirect("/mysite/viewallcontactsbygroup.jsp");	

	}
	else {
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/error.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	System.out.println("I am here in GetAllEMailListbyGroupServlet post method ");
        doGet(request, response);
    }

}

