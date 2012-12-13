/**
 * 
 */
package org.nikolay.books.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.UserDAO;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Stas Sarosek
 * @version 1.0
 */
@WebServlet(name = "authentication", urlPatterns = { "/authentication" })
public class AuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String HOME_PAGE = "home.jsp";
	private static final String AUTHENTIFICATION_PAGE = "authentication.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(AUTHENTIFICATION_PAGE);
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

		if (!username.isEmpty() && !password.isEmpty()) {
			IUserDAO userDAO = new UserDAO();
			User user = new UserEntity();
			user = userDAO.getAuthentication(username, password);

			if (user != null) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(HOME_PAGE);
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(AUTHENTIFICATION_PAGE);
				requestDispatcher.forward(request, response);
			}

		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(AUTHENTIFICATION_PAGE);
			requestDispatcher.forward(request, response);
		}
	}

}