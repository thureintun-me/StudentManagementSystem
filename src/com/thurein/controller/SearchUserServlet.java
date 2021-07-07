package com.thurein.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.UserDao;
import com.thurein.dto.UserResponseDTO;
import com.thurein.model.User;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDao();
		UserResponseDTO dto = null;
		if(request.getParameter("id").equals("")) {
			 dto =dao.searchByName(request.getParameter("name"));
		}else if(request.getParameter("name").equals("")) {
			 dto  = dao.searchById(request.getParameter("id"));
		}else if(!request.getParameter("id").equals("") && !request.getParameter("name").equals("")) {
			 dto = dao.searchByNameAndId(request.getParameter("name"), request.getParameter("id"));
				
		}
		
		
		
		if(dto != null) {
			request.setAttribute("users", dto);
			request.getRequestDispatcher("UserSearch.jsp").include(request, response);
		}else {
			request.setAttribute("noUser", new String("No user Found"));
			request.getRequestDispatcher("UserSearch.jsp").include(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
