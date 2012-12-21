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

import org.nikolay.books.api.dao.ISaleDAO;
import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.Sale;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.SaleDAO;
import org.nikolay.books.dpl.dao.UserDAO;
import org.nikolay.books.dpl.entity.SaleEntity;
import org.nikolay.books.dpl.entity.UserEntity;
import org.nikolay.books.web.util.EmailValidationUtil;
import org.nikolay.books.web.util.PasswordValidationUtil;

/**
 * @author Nikolay Dagil
 * 
 */
@WebServlet(name = "saleRegistration", urlPatterns = { "/saleRegistration" })
public class SaleRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_PAGE = "success.jsp";
	private static final String SALE_REGISTRATION_PAGE = "saleRegistration.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(SALE_REGISTRATION_PAGE);
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

		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String role = request.getParameter("role");

		if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()
				&& !firstName.isEmpty() && !lastName.isEmpty()
				&& !address.isEmpty()) {

			IUserDAO userDAO = new UserDAO();
			EmailValidationUtil emailValidation = new EmailValidationUtil();
			PasswordValidationUtil passwordValidation = new PasswordValidationUtil();

			if (!userDAO.isExistsByEmail(email)
					&& !userDAO.isExistsByUsername(username)
					&& !emailValidation.isNormalEmail(email)
					&& passwordValidation.isNormalPassword(password)) {

				User user = new UserEntity();
				user.setPassword(password);
				user.setUsername(username);
				user.setEmail(email);
				user.setLastName(lastName);
				user.setFirstName(firstName);
				user.setMobile(mobile);
				user.setIsActive(true);
				user.setCreateDate(new Date());

				ISaleDAO saleDAO = new SaleDAO();
				Sale sale = new SaleEntity();
				sale.setAddress(address);
				sale.setUser(user);
				sale.setCity(city);
				sale.setCountry(country);
				sale.setRole(role);
				sale.setPostcode(Integer.parseInt(postcode));

				System.out.println("****************");
				saleDAO.save(sale);

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(SUCCESS_PAGE);
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(SALE_REGISTRATION_PAGE);
				requestDispatcher.forward(request, response);
			}

		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(SALE_REGISTRATION_PAGE);
			requestDispatcher.forward(request, response);
		}

	}
}