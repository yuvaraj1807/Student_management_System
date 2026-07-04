package Controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Student;
import serviceimpl.StudentServiceImpl;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        int id =
                Integer.parseInt(request.getParameter("id"));

        String password =
                request.getParameter("password");

        StudentServiceImpl service =
                new StudentServiceImpl();

        Student student =
                service.loginStudent(id, password);
        System.out.println("ID = " + id);
        System.out.println("Password = " + password);

        if (student != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute("student", student);

            response.sendRedirect("studentDashboard.jsp");
        } else {
            response.getWriter()
                    .println("Invalid Student ID or Password");
        }
    }
}