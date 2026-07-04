<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="css/addstudent.css">
</head>
<body>

<div class="container">

<h2> Add Student</h2>

<form action="AddStudentServlet" method="post">

<input type="text" name="name" placeholder="Enter Name" required>

<input type="number" name="age" placeholder="Enter Age" required>

<input type="text" name="gender" placeholder="Enter Gender" required>

<input type="text" name="department" placeholder="Enter Department" required>

<input type="email" name="email" placeholder="Enter Email" required>

<input type="text" name="phone" placeholder="Enter Phone Number" required>

<input type="text" name="password" placeholder="Enter Password" required>

<input type="submit" value="Add Student">

</form>

<a href="index.jsp" class="back-btn"> Back to Home</a>

</div>

</body>
</html>