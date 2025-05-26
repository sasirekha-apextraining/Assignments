package assign.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

public class AddEMailAddressServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String errors = "";
		// Step1: capture input and populate the VO
		EMailAddressVOO eMailAddressVO = new EMailAddressVOO();
		// Get registration details and set to the EMailAddress
		// Step:1
		eMailAddressVO.seteMailID(request.getParameter("emailid"));
		eMailAddressVO.setfName(request.getParameter("fname"));
		eMailAddressVO.setmName(request.getParameter("mname"));
		eMailAddressVO.setlName(request.getParameter("lname"));
		eMailAddressVO.sethPhone(request.getParameter("hphone"));
		eMailAddressVO.setwPhone(request.getParameter("wphone"));
		eMailAddressVO.setmPhone(request.getParameter("mphone"));
		eMailAddressVO.setgroupID(request.getParameter("group"));

		// Step2: Do processing or Business logic
		EMailBO eMailBO = new EMailBO();

		try {
			eMailBO.addEMailAddress(eMailAddressVO);
		} catch (EMailValidationException emve) {
			errors = emve.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step3: Response Back
		if (errors.equals("")) {
			response.sendRedirect("/mysite/home.jsp");
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/addcontact.jsp");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
