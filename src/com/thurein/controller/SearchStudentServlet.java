 package com.thurein.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.StudentDao;
import com.thurein.dao.UserDao;
import com.thurein.dto.StudentResponseDTO;
import com.thurein.dto.UserResponseDTO;

/**
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		StudentDao dao = new StudentDao();
		StudentResponseDTO dto=null;
		ArrayList<StudentResponseDTO> list = null;
		
		
		if(request.getParameter("id").equals("") && request.getParameter("class").equals("")) {
			 dto =dao.searchByName(request.getParameter("name"));
		}else if(request.getParameter("name").equals("") && request.getParameter("class").equals("") ) {
			 dto  = dao.searchById(request.getParameter("id"));
		}else if(request.getParameter("id").equals("") && request.getParameter("name").equals("")) {
			 list = dao.searchByClass(request.getParameter("class"));
				
		}
		
		if(dto != null) {
			request.setAttribute("student", dto);
			request.getRequestDispatcher("StudentSearch.jsp").forward(request, response);;
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("StudentSearch.jsp").include(request, response);
		}
			
		
		
		
		
		
		
		
		
		
		
	}

}
