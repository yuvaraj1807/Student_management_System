<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="form-container">

    <h2> Student Login</h2>

    <form action="StudentLoginServlet" method="post">
        <input type="number"
               name="id"
               placeholder="Enter Student ID"
               required>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               required>

        <input type="submit" value="Login">
    </form>

    <a href="login.jsp" class="back-btn"> Back</a>

</div>

</body>
</html>