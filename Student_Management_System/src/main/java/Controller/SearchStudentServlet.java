package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Student;
import serviceimpl.StudentServiceImpl;
@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StudentServiceImpl service = new StudentServiceImpl();

        Student s = service.getStudentById(id);

        List<Student> list = new ArrayList<>();

        if (s != null) {
            list.add(s);
        }

        request.setAttribute("students", list);

        request.getRequestDispatcher("viewStudents.jsp")
               .forward(request, response);
    }
}