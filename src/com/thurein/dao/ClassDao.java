package com.thurein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thurein.dto.ClassRequestDTO;
import com.thurein.dto.ClassResponseDTO;
import com.thurein.dto.UserRequestDTO;
import com.thurein.dto.UserResponseDTO;

public class ClassDao {

static Connection con = null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	public void insertUser(ClassRequestDTO myclass) {
		
		String sql = "insert into myclass (id,name) values (?, ?)";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(1, myclass.getId());
			ps.setString(2, myclass.getName());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
public ArrayList<ClassResponseDTO> selectAll(){
		
		ArrayList<ClassResponseDTO> classList = new ArrayList<ClassResponseDTO>();
		String sql ="select * from myclass";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ClassResponseDTO res  =new  ClassResponseDTO();
				res.setId(rs.getString("id"));
				 res.setName(rs.getString("name"));
				 
				 classList.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classList;
		
	}
}
