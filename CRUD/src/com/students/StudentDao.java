package com.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	//create method
	public static boolean createStudent(Student s) {
		boolean f = false;
		
		try {
			Connection con = DbConncetion.createCon();
			
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			//parameter
			ps.setString(1, s.getStudentName());
			ps.setString(2, s.getStudentPhone());
			ps.setString(3, s.getStudentCity());
			
			ps.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {e.printStackTrace();}
		return f;
		
	}

	//delete
	public static boolean deleteStudent(int userid) {
     boolean f = false;
		
		try {
			Connection con = DbConncetion.createCon();
			
			String q = "delete from students where id=?";
			PreparedStatement ps = con.prepareStatement(q);
			//parameter
			ps.setInt(1,userid);
			
			ps.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		return f;
	}
	//display

	public static void showAllStudents() {
		try {
			Connection con = DbConncetion.createCon();
			
			String q = "select*from students";
			
			Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(q);
		    while(rs.next())
		    {
		    	int id = rs.getInt(1);
		        String name = rs.getString(2);
		        String phone = rs.getString(3);
		        String city = rs.getString(4);
		        
		        System.out.println("Id: "+id);
		        System.out.println("Name: "+ name);
		        System.out.println("Phone: "+phone);
		        System.out.println("City: "+city);
		        System.out.println("**********************");

		    }
			
			
			
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
	

