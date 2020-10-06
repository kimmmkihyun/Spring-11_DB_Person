package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PDto;

public class PDao {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String user="jspid";
	private String pw="jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private static PDao dao = null;
	
	// ΩÃ±€≈Ê ∆–≈œ¿∏∑Œ ∞¥√º ∏∏µÈ±‚
	private PDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static PDao getInstance(){
		if(dao == null) {
			dao = new PDao();
		}
		return dao;
	}
	
	public void write(String id,String name,String age){
		String sql = "insert into person values(person_seq.nextval,?,?,?)"; 
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, Integer.parseInt(age));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception e) {
				
			}
		}
	}//
	
	public ArrayList<PDto> list(){
		
		ArrayList<PDto> lists = new ArrayList<PDto>();
		String sql = "select * from person order by num asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				PDto dto = new PDto(num, id, name, age);
				lists.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
			}catch(Exception e) {
				
			}
		} 
		
		System.out.println(lists.size());
		return lists;
	}

	public PDto oneSelect(String num) {
		
		String sql = "select * from person where num=?";
		PDto dto = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(num));
			
			rs=ps.executeQuery();
			
			if (rs.next()) {
				int num2 = rs.getInt("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				dto = new PDto(num2, id, name, age);
 			}	
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
			}catch(Exception e) {
				
			}
		} 
		return dto;
		
	}//oneSelect

	public void modifyByNum(PDto dto) {
		
		String sql = "update person set id=?, name=?, age=? where num=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setInt(4, dto.getNum());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception e) {
				
			}
		}
		
	} //modifyByNum

	public void deleteByNum(int num) {

		String sql = "delete from person where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception e) {
				
			}
		}
		
	}//deleteByNum
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	

