package com.thurein.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.UserDao;
import com.thurein.dto.UserRequestDTO;
import com.thurein.model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		User user = new User();
		
		user.setId(request.getParameter("id"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		
		 if(!user.getPassword().equals(request.getParameter("confirmPass"))){
			request.setAttribute("error", "Password do not match");
			request.getRequestDispatcher("UserRegister.jsp").include(request, response);
			
		}else {
			if(user.getId().equals("") || user.getName().equals("") || user.getPassword().equals("")) {
				request.setAttribute("error", "fiels cannot be balnk");
				request.getRequestDispatcher("UserRegister.jsp").include(request, response);
			}else {
				request.setAttribute("error", "Successfully Updated...");
				
				UserDao dao = new UserDao();
				UserRequestDTO dto = new UserRequestDTO();
				dto.setId(user.getId());
				dto.setName(user.getName());
				dto.setPassword(user.getPassword());
				dao.updateUser(dto);
				
				request.getRequestDispatcher("UserSearch.jsp").include(request, response);
			}
		}
	}

}
