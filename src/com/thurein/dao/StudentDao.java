package com.thurein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thurein.dto.StudentRequestDTO;
import com.thurein.dto.StudentResponseDTO;
import com.thurein.dto.UserRequestDTO;
import com.thurein.dto.UserResponseDTO;



public class StudentDao {

	
static Connection con = null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	public void insertStudent(StudentRequestDTO student) {
		
		String sql = "insert into student (student_id,student_name,class_name,register_date,status) values (?,?,?, ?, ?)";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(1, student.getStudentId());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getClassName());
			ps.setObject(4, student.getRegisterDate());
			ps.setString(5, student.getStatus());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public StudentResponseDTO searchById(String id) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where student_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				res.setStudentId((rs.getString("student_id")));
				 res.setStudentName((rs.getString("student_name")));
				 res.setClassName((rs.getString("class_name")));
				 res.setRegisterDate(rs.getDate("register_date"));
				 res.setStatus(rs.getString("status"));;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public StudentResponseDTO searchByName(String name) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where student_name = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				res.setStudentId((rs.getString("student_id")));
				 res.setStudentName((rs.getString("student_name")));
				 res.setClassName((rs.getString("class_name")));
				 res.setRegisterDate(rs.getDate("register_date"));
				 res.setStatus(rs.getString("status"));;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public ArrayList<StudentResponseDTO> searchByClass(String name) {
		ArrayList<StudentResponseDTO> myList = new ArrayList<StudentResponseDTO>();
		String sql = "select * from student where class_name = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentResponseDTO res = new StudentResponseDTO();
				res.setStudentId((rs.getString("student_id")));
				 res.setStudentName((rs.getString("student_name")));
				 res.setClassName((rs.getString("class_name")));
				 res.setRegisterDate(rs.getDate("register_date"));
				 res.setStatus(rs.getString("status"));;
				 myList.add(res);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myList;
		
	}
	
	public StudentResponseDTO searchByIdAndNameAndClass(String id,String name,String myclass) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where student_id=? &  student_name = ? & class_name=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, myclass);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 res.setStudentId((rs.getString("student_id")));
				 res.setStudentName((rs.getString("student_name")));
				 res.setClassName((rs.getString("class_name")));
				 res.setRegisterDate(rs.getDate("register_date"));
				 res.setStatus(rs.getString("status"));;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public void updateStudent(StudentRequestDTO student) {
		String sql = "update  student set student_id=? , student_name=?,class_name=?,register_date=?,status=?  where student_id=?";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(1,student.getStudentId());
			 ps.setString(2,student.getStudentName());
			 ps.setString(3,student.getClassName());
			 ps.setObject(4,student.getRegisterDate());
			 ps.setString(5,student.getStatus());
			 ps.setString(6,student.getStudentId());
			 
			 
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void deleteStudent(StudentRequestDTO student) {
		String sql = "delete from student where student_id=?";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(1 , student.getStudentId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
