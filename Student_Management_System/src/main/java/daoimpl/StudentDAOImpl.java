package daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.StudentDAO;
import model.Student;
import util.DBConnection;

public class StudentDAOImpl implements StudentDAO{
	Connection con=DBConnection.getConnection();
	
	@Override
	public boolean addStudent(Student student) {
		boolean flag=false;
		try {
			String sql="INSERT INTO students(name,age,gender,department,email,phone,password)"
					+ "VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,student.getname());
			ps.setInt(2, student.getage());
			ps.setString(3, student.getgender());
			ps.setString(4,student.getdepartment());
			ps.setString(5,student.getemail());
			ps.setString(6,student.getphone());
			ps.setString(7,student.getpassword());
			
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				flag=true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<Student> getAllStudents(){
		
		List<Student> list=new ArrayList<>();
		
		try {
			String sql="SELECT * FROM students";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Student s=new Student();
				
				s.setid(rs.getInt("id"));
				s.setname(rs.getString("name"));
				s.setage(rs.getInt("age"));
				s.setgender(rs.getString("gender"));
				s.setdepartment(rs.getString("department"));
				s.setemail(rs.getString("email"));
				s.setphone(rs.getString("phone"));
				
				list.add(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Student getStudentById(int id) {
		Student s=null;
		
		try {
			String sql="SELECT * FROM students WHERE id=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				s=new Student();
				
				s.setid(rs.getInt("id"));
				s.setname(rs.getString("name"));
				s.setage(rs.getInt("age"));
				s.setgender(rs.getString("gender"));
				s.setdepartment(rs.getString("department"));
				s.setemail(rs.getString("email"));
				s.setphone(rs.getString("phone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	@Override
	public boolean updateStudent(Student student) {
		boolean flag=false;
		
		try {
			String sql="UPDATE students SET name=?,age=?,gender=?,department=?,email=?,phone=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,student.getname());
			ps.setInt(2,student.getage());
			ps.setString(3,student.getgender());
			ps.setString(4,student.getdepartment());
			ps.setString(5, student.getemail());
			ps.setString(6,student.getphone());
			
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean deleteStudent(int id) {
	    boolean flag = false;

	    try {
	        String sql = "DELETE FROM students WHERE id=?";

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            flag = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}
	
	@Override
	public Student loginStudent(int id, String password) {

	    Student student = null;

	    try {

	        String sql =
	                "SELECT * FROM students WHERE id=? AND password=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, id);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            student = new Student();

	            student.setid(rs.getInt("id"));
	            student.setname(rs.getString("name"));
	            student.setage(rs.getInt("age"));
	            student.setgender(rs.getString("gender"));
	            student.setdepartment(rs.getString("department"));
	            student.setemail(rs.getString("email"));
	            student.setphone(rs.getString("phone"));
	            student.setpassword(rs.getString("password"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return student;
	}
}