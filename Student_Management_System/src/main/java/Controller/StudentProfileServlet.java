package Controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Student;

@WebServlet("/StudentProfileServlet")
public class StudentProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null ||
            session.getAttribute("student") == null) {

            response.sendRedirect("studentLogin.jsp");
            return;
        }

        Student s =
                (Student) session.getAttribute("student");

        response.getWriter().println(
                "<h1>Student Profile</h1>" +
                "<p>ID : " + s.getid() + "</p>" +
                "<p>Name : " + s.getname() + "</p>" +
                "<p>Department : " + s.getdepartment() + "</p>" +
                "<p>Email : " + s.getemail() + "</p>" +
                "<p>Phone : " + s.getphone() + "</p>"
        );
    }
}