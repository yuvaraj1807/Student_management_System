package Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import serviceimpl.StudentServiceImpl;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet{
	
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException ,IOException{
		StudentServiceImpl service=new StudentServiceImpl();
		List<Student> list=service.getAllStudents();
		request.setAttribute("students", list);
		
		request.getRequestDispatcher("viewStudents.jsp")
			.forward(request, response);
	}
}