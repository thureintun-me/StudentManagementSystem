package com.thurein.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.ClassDao;
import com.thurein.dao.UserDao;
import com.thurein.dto.ClassRequestDTO;
import com.thurein.dto.UserRequestDTO;
import com.thurein.model.MyClass;
import com.thurein.model.User;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
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
		MyClass myClass = new MyClass();
		myClass.setId(request.getParameter("id"));
		myClass.setName(request.getParameter("name"));
		
		
		
			if(myClass.getId().equals("") || myClass.getName().equals("") ) {
				request.setAttribute("error", "fiels cannot be balnk");
				request.getRequestDispatcher("UserRegister.jsp").include(request, response);
			}else {
				request.setAttribute("error", "Successfully Saved...");
				
				ClassDao dao = new ClassDao();
				ClassRequestDTO dto = new ClassRequestDTO();
				dto.setId(myClass.getId());
				dto.setName(myClass.getName());
				
				dao.insertUser(dto);
				
				request.getRequestDispatcher("ClassRegister.jsp").include(request, response);
			}
		
		
	}

}
