<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
 <form action="userRegistration" method="post">
 First Name:
 <input type="text" name="firstName"><br>
 Last Name:
 <input type="text" name="lastName"><br>
 Email:
 <input type="text" name="email"><br>
 Username:
 <input type="text" name="userName"><br>
 Password:
 <input type="password" name="password"><br>
 <input type="submit" value="register">
 <input type="button" value="cancel">
 </form>
</body>
</html>