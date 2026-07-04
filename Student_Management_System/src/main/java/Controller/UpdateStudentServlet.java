package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import serviceimpl.StudentServiceImpl;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Open edit page
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StudentServiceImpl service = new StudentServiceImpl();

        Student student = service.getStudentById(id);

        request.setAttribute("student", student);

        request.getRequestDispatcher("editStudent.jsp")
               .forward(request, response);
    }

    // Update student details
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Student s = new Student();

        s.setid(id);
        s.setname(name);
        s.setage(age);
        s.setgender(gender);
        s.setdepartment(department);
        s.setemail(email);
        s.setphone(phone);

        StudentServiceImpl service = new StudentServiceImpl();

        boolean status = service.updateStudent(s);

        if (status) {
            response.sendRedirect("ViewStudentServlet");
        } else {
            response.getWriter().println("Update Failed");
        }
    }
}