<%@ page import="model.Student" %>

<%
Student s = (Student) session.getAttribute("student");

if(s == null){
    response.sendRedirect("studentLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
<link rel="stylesheet" href="css/studentdashboard.css">
</head>
<body>

<div class="container">

    <h2>Welcome, <%= s.getname() %></h2>

    <table>
        <tr>
            <th>ID</th>
            <td><%= s.getid() %></td>
        </tr>

        <tr>
            <th>Name</th>
            <td><%= s.getname() %></td>
        </tr>

        <tr>
            <th>Age</th>
            <td><%= s.getage() %></td>
        </tr>

        <tr>
            <th>Gender</th>
            <td><%= s.getgender() %></td>
        </tr>

        <tr>
            <th>Department</th>
            <td><%= s.getdepartment() %></td>
        </tr>

        <tr>
            <th>Email</th>
            <td><%= s.getemail() %></td>
        </tr>

        <tr>
            <th>Phone</th>
            <td><%= s.getphone() %></td>
        </tr>
    </table>

    <br>

    <a href="LogoutServlet" class="btn">
        Logout
    </a>

</div>

</body>
</html>