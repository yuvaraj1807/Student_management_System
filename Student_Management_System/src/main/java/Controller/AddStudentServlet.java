package Controller;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import serviceimpl.StudentServiceImpl;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Student s = new Student();

        s.setname(name);
        s.setage(age);
        s.setgender(gender);
        s.setdepartment(department);
        s.setemail(email);
        s.setphone(phone);
        s.setpassword(password);

        StudentServiceImpl service = new StudentServiceImpl();

        boolean status = service.addStudent(s);

        if (status) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Failed to Add Student");
        }
    }
}