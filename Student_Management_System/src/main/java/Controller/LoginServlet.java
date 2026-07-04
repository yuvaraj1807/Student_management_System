package Controller;

import java.io.IOException;

import daoimpl.AdminDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String username=
                request.getParameter("username");

        String password=
                request.getParameter("password");

        AdminDAOImpl dao=
                new AdminDAOImpl();

        boolean status=
                dao.login(username,password);

        if(status) {

            HttpSession session=
                    request.getSession();

            session.setAttribute(
                    "admin", username);

            response.sendRedirect(
                    "index.jsp");
        }
        else {

            response.getWriter()
                    .println("Invalid Login");
        }
    }
}