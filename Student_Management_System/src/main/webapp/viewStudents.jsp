<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>
<link rel="stylesheet" href="css/viewstudents.css">
</head>
<body>

<div class="container">

    <h2>📋 Student List</h2>

    <form action="SearchStudentServlet" method="get" class="search-form">
        <input type="number" name="id" placeholder="Enter Student ID" required>
        <input type="submit" value="Search">
        <a href="ViewStudentServlet">Show All</a>
        <a href="index.jsp">Home</a>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>

        <%
        @SuppressWarnings("unchecked")
        List<Student> list =
            (List<Student>) request.getAttribute("students");

        if (list != null && !list.isEmpty()) {
            for (Student s : list) {
        %>

        <tr>
            <td><%= s.getid() %></td>
            <td><%= s.getname() %></td>
            <td><%= s.getage() %></td>
            <td><%= s.getgender() %></td>
            <td><%= s.getdepartment() %></td>
            <td><%= s.getemail() %></td>
            <td><%= s.getphone() %></td>

            <td>
                <a class="btn update"
                   href="UpdateStudentServlet?id=<%=s.getid()%>">
                    Update
                </a>
            </td>

            <td>
                <a class="btn delete"
                   href="DeleteStudentServlet?id=<%=s.getid()%>"
                   onclick="return confirm('Are you sure you want to delete this student?')">
                    Delete
                </a>
            </td>
        </tr>

        <%
            }
        } else {
        %>

        <tr>
            <td colspan="9">No students found.</td>
        </tr>

        <%
        }
        %>

    </table>

</div>

</body>
</html>