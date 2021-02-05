package controlls;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AgentBean;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "logincontroller", urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			response.sendRedirect("login.jsp");
		}

		try{for (Cookie aCookie : cookies) {
		    String email = aCookie.getValue();
		 
		    if (email.equals("bob@blobland.com")) {
		    	response.sendRedirect("bob.jsp");
		         
		        break;
		    } else if (email.equals("alice@wonderland.com")){
		    	response.sendRedirect("alice.jsp");
		    } else{response.sendRedirect("login.jsp");}
		     
		}}catch(Exception e){
			out.print("something went wrong: " + e);
		}

		
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Just for testing
		System.out.println("In the login servlet");

		PrintWriter out = response.getWriter();

		// Instantiate the class agentBean

		AgentBean agentBean = new AgentBean();

		// Read in email and password from index.jsp
		String email = request.getParameter("email").toLowerCase();
		String passWord = request.getParameter("password");

		String aliceName = "alice";
		String bobName = "bob";

		// If either email and password are not empty
		// notifty user and return to index.jsp
		if (email.isEmpty() || passWord.isEmpty()) {
			System.out.println("Fields can not be empty");
			response.sendRedirect("index.jsp");

			// if password and email are correct,send user to his/her page and create
			// an email cookie
			// send email value to

		}
		if (email.equals("alice@wonderland.com") && agentBean.validate(passWord)) {
			Cookie aliceMailCk = new Cookie("email", email);
			aliceMailCk.setMaxAge(604800); // the cookie will exist for 7 days
			response.addCookie(aliceMailCk);
			request.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("alice.jsp");
			rd.forward(request, response);
		}

		else if (email.equals("bob@blobland.com") && agentBean.validate(passWord)) {
			Cookie bobMailCk = new Cookie("email", email);
			bobMailCk.setMaxAge(604800); // the cookie will exist for 7 days
			response.addCookie(bobMailCk);
			request.setAttribute("email", email);
			RequestDispatcher rd2 = request.getRequestDispatcher("bob.jsp");
			rd2.forward(request, response);

		} else {
			out.println("Invalid credentials, try again");
			response.sendRedirect("index.jsp");
		}

	}
}