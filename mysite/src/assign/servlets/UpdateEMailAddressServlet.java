package assign.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/**
 * Servlet implementation class UpdateEMailAddressServlet
 */

public class UpdateEMailAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errors = "";
		response.setContentType("text/html");

		HttpSession session = request.getSession();

		EMailBO eMailBO = new EMailBO();
		EMailAddressVOO emailVO = null;

		emailVO = (EMailAddressVOO) session.getAttribute("eMailAddressVOO");
		String wphone = request.getParameter("wphone");
		String mphone = request.getParameter("mphone");

		try {
			emailVO.setmPhone(mphone);
			emailVO.setwPhone(wphone);
			eMailBO.updateEMailAddress(emailVO);
		} catch (EMailValidationException emve) {
			errors = emve.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (errors.equals("")) {
			response.sendRedirect("/mysite/home.jsp");
		} else {
			System.out.println(request.getRequestURI());
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/deletecontact.jsp");
		}

	}

}
