package com.thurein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thurein.dto.UserRequestDTO;
import com.thurein.dto.UserResponseDTO;
import com.thurein.model.User;

public class UserDao {


	static Connection con = null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	public void insertUser(UserRequestDTO user) {
		
		String sql = "insert into user (id,name,password) values (?, ?, ?)";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateUser(UserRequestDTO user) {
		String sql = "update  user set name=? , password=? where id=?";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(3, user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void deleteUser(UserRequestDTO user) {
		String sql = "delete from user where id=?";
		try {
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.setString(1 , user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public UserResponseDTO searchById(String id) {
		UserResponseDTO res = new UserResponseDTO();
		String sql = "select * from user where id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 res.setId(rs.getString("id"));
				 res.setName(rs.getString("name"));
				 res.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public UserResponseDTO searchByName(String name) {
		UserResponseDTO res = new UserResponseDTO();
		String sql = "select * from user where name = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 res.setId(rs.getString("id"));
				 res.setName(rs.getString("name"));
				 res.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public UserResponseDTO searchByNameAndId(String name,String id) {
		UserResponseDTO res = new UserResponseDTO();
		String sql = "select * from user where name = ? && id = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 res.setId(rs.getString("id"));
				 res.setName(rs.getString("name"));
				 res.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public UserResponseDTO selectOne(UserRequestDTO userDTO) {
		
		UserResponseDTO res = new UserResponseDTO();
		String sql = "select * from user where id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 res.setId(rs.getString("id"));
				 res.setName(rs.getString("name"));
				 res.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
		
	}
	
	public ArrayList<UserResponseDTO> selectAll(){
		
		ArrayList<UserResponseDTO> userList = new ArrayList<UserResponseDTO>();
		String sql ="select * from user";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				UserResponseDTO res  =new  UserResponseDTO();
				res.setId(rs.getString("id"));
				 res.setName(rs.getString("name"));
				 res.setPassword(rs.getString("password"));
				 userList.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
		
	}
}
