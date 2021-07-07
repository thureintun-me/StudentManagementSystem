package com.thurein.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.StudentDao;
import com.thurein.dao.UserDao;
import com.thurein.dto.StudentRequestDTO;
import com.thurein.dto.UserRequestDTO;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id"); 
		System.out.println(id);
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(id);
		StudentDao dao = new StudentDao();
		dao.deleteStudent(dto);
		out.println("<p style='color:green'>Successfully Delete</p>");
		request.getRequestDispatcher("StudentSearch.jsp").include(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
