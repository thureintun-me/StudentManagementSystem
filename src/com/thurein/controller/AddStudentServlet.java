package com.thurein.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thurein.dao.StudentDao;

import com.thurein.dto.StudentRequestDTO;

import com.thurein.model.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
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
		Student student = new Student();
		student.setStudentId(request.getParameter("id"));
		student.setStudentName(request.getParameter("name"));
		student.setClassName(request.getParameter("myclass"));
		
		student.setStatus(request.getParameter("status"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String myDate = year+"/"+month+"/"+day;
		Date date = null;
		try {
			date = new SimpleDateFormat("YY/MM/DD").parse(myDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		student.setRegisterDate((date));
		
		System.out.println(date);
		
		/*
		 * System.out.println(request.getParameter("myclass"));
		 * System.out.println(request.getParameter("status"));
		 * System.out.println(request.getParameter("id"));
		 * System.out.println(request.getParameter("name"));
		 * System.out.println(request.getParameter("year"));
		 * System.out.println(request.getParameter("month"));
		 * System.out.println(request.getParameter("day"));
		 */
		
			if(student.getStudentId().equals("") || student.getStudentName().equals("") || student.getStatus().equals("") || 
					
					student.getClassName().equals("") ) {
				request.setAttribute("error", "fiels cannot be balnk");
				request.getRequestDispatcher("StudentRegister.jsp").include(request, response);
			}else {
				request.setAttribute("error", "Successfully Saved...");
				
				StudentDao dao = new StudentDao();
				StudentRequestDTO dto = new StudentRequestDTO();
				dto.setStudentId(student.getStudentId());
				dto.setStudentName(student.getStudentName());
				dto.setClassName(student.getClassName());
				dto.setRegisterDate(student.getRegisterDate());
				dto.setStatus(student.getStatus());
				dao.insertStudent(dto);
				
				request.getRequestDispatcher("StudentRegister.jsp").include(request, response);
			}
		
	}

}
