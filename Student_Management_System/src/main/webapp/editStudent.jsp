<%@ page import="model.Student" %>

<%
Student s = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" href="css/addstudent.css">
</head>
<body>

<div class="container">

    <h2>✏️ Update Student</h2>

    <form action="UpdateStudentServlet" method="post">

        <input type="hidden" name="id" value="<%=s.getid()%>">

        <input type="text"
               name="name"
               value="<%=s.getname()%>"
               placeholder="Enter Name"
               required>

        <input type="number"
               name="age"
               value="<%=s.getage()%>"
               placeholder="Enter Age"
               required>

        <input type="text"
               name="gender"
               value="<%=s.getgender()%>"
               placeholder="Enter Gender"
               required>

        <input type="text"
               name="department"
               value="<%=s.getdepartment()%>"
               placeholder="Enter Department"
               required>

        <input type="email"
               name="email"
               value="<%=s.getemail()%>"
               placeholder="Enter Email"
               required>

        <input type="text"
               name="phone"
               value="<%=s.getphone()%>"
               placeholder="Enter Phone Number"
               required>

        <input type="submit" value="Update Student">

    </form>

    <a href="ViewStudentServlet" class="back-btn">
        ⬅ Back to Student List
    </a>

</div>

</body>
</html>