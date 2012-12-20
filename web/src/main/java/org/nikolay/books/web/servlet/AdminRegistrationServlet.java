/**
 * 
 */
package org.nikolay.books.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nikolay.books.api.dao.IAdminDAO;
import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.Admin;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.AdminDAO;
import org.nikolay.books.dpl.dao.UserDAO;
import org.nikolay.books.dpl.entity.AdminEntity;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * 
 */
@WebServlet(name = "adminRegistration", urlPatterns = { "/adminRegistration" })
public class AdminRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_PAGE = "success.jsp";
	private static final String ADMIN_REGISTRATION_PAGE = "adminRegistration.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(ADMIN_REGISTRATION_PAGE);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobile = request.getParameter("mobile");

		String role = request.getParameter("role");

		if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()
				&& !firstName.isEmpty() && !lastName.isEmpty()) {

			IUserDAO userDAO = new UserDAO();

			if (!userDAO.isExistsByEmail(email)
					&& !userDAO.isExistsByUsername(username)) {

				User user = new UserEntity();
				user.setPassword(password);
				user.setUsername(username);
				user.setEmail(email);
				user.setLastName(lastName);
				user.setFirstName(firstName);
				user.setMobile(mobile);
				user.setIsActive(true);
				user.setCreateDate(new Date());

				// userDAO.save(user);

				IAdminDAO adminDAO = new AdminDAO();
				Admin admin = new AdminEntity();
				admin.setUser(user);
				admin.setRole(role);
				

				System.out.println("****************");
				adminDAO.save(admin);

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(SUCCESS_PAGE);
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(ADMIN_REGISTRATION_PAGE);
				requestDispatcher.forward(request, response);
			}

		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(ADMIN_REGISTRATION_PAGE);
			requestDispatcher.forward(request, response);
		}

	}
}