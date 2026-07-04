<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="form-container">

    <h2> Admin Login</h2>

    <form action="LoginServlet" method="post">
        <input type="text"
               name="username"
               placeholder="Enter Username"
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