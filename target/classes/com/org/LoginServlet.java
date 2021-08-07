package com.org;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (
		description = "Login Servlet Testing",
		urlPatterns = { "/LoginServlet" },
		initParams = {
				@WebInitParam(name = "user", value = "Pooja"),
				@WebInitParam(name = "password", value = "pooja14206")
		}
)
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get request parameters for userID and password
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		
		//get servlet config init params
		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		if(userID.equals(user) && password.equals(pwd)) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>Either username or password is incorrect!</font>");
			rd.include(req, resp);
		}
	}	

}
