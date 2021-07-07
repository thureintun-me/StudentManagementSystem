package com.thurein.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.UserDao;
import com.thurein.dto.UserResponseDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ArrayList<UserResponseDTO> dto = new ArrayList<UserResponseDTO>();
		UserDao dao = new UserDao();
		
		dto = dao.selectAll();
		String id= request.getParameter("id");
		String pass = request.getParameter("password");
		String dId = "";
		String dPass = "";
		String dName = "";
		
		for(UserResponseDTO o:dto) {
			if(id.equals(o.getId()) && pass.equals(o.getPassword())) {
				dId = o.getId();
				dPass=o.getPassword();
				dName=o.getName();
			}
		}
		
		if(id.equals(dId) && pass.equals(dPass)) {
			request.getSession().setAttribute("myId", dId);
			request.getSession().setAttribute("myName", dName);
			request.getSession().setAttribute("myDate", new Date());
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			
		}else {
			out.println("<p>Register First Please</p>");
			request.getRequestDispatcher("NewUserRegister.jsp").include(request, response);;
			
		}
	}

}
