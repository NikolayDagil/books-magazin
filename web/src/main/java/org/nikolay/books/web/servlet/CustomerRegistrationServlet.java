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

import org.nikolay.books.api.dao.ICustomerDAO;
import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.Customer;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.CustomerDAO;
import org.nikolay.books.dpl.dao.UserDAO;
import org.nikolay.books.dpl.entity.CustomerEntity;
import org.nikolay.books.dpl.entity.UserEntity;
import org.nikolay.books.web.util.EmailValidationUtil;

/**
 * @author Nikolay Dagil
 * 
 */
@WebServlet(name = "customerRegistration", urlPatterns = { "/customerRegistration" })
public class CustomerRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_PAGE = "success.jsp";
	private static final String CUSTOMER_REGISTRATION_PAGE = "customerRegistration.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(CUSTOMER_REGISTRATION_PAGE);
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

		if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()
				&& !firstName.isEmpty() && !lastName.isEmpty()
				&& !address.isEmpty()) {

			IUserDAO userDAO = new UserDAO();

			EmailValidationUtil emailValidation = new EmailValidationUtil();

			if (!userDAO.isExistsByEmail(email)
					&& !userDAO.isExistsByUsername(username)
					&& emailValidation.isNormalEmail(email)) {

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

				ICustomerDAO customerDAO = new CustomerDAO();
				Customer customer = new CustomerEntity();
				customer.setAddress(address);
				customer.setUser(user);
				customer.setCity(city);
				customer.setCountry(country);
				customer.setPostcode(Integer.parseInt(postcode));

				System.out.println("****************");
				customerDAO.save(customer);

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(SUCCESS_PAGE);
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(CUSTOMER_REGISTRATION_PAGE);
				requestDispatcher.forward(request, response);
			}

		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(CUSTOMER_REGISTRATION_PAGE);
			requestDispatcher.forward(request, response);
		}

	}
}
