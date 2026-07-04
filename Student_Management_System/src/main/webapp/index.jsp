<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
if(session.getAttribute("admin")==null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>

<div class="header">
    <h1> Student Management System</h1>

    <div class="logout">
        <a href="LogoutServlet">Logout</a>
    </div>
</div>

<div class="welcome">
    Welcome,
    <%= session.getAttribute("admin") %>
</div>

<div class="menu">

    <a href="addStudent.jsp" class="card">
        <span class="card-title"> Add Student</span><br>
        Add new student details.
    </a>

    <a href="ViewStudentServlet" class="card">
        <span class="card-title"> View Students</span><br>
        View all student records.
    </a>

    <a href="ViewStudentServlet" class="card">
        <span class="card-title"> Search Student</span><br>
        Search students by ID.
    </a>

</div>

</body>
</html>