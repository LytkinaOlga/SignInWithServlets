<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h2>SIGN IN!</h2>
    <form action="#" method="post" class="was-validated">
        <div class="form-group">
            <label>Input your login</label>
            <input name="login" class="form-control" placeholder="login" required>
            <div class="invalid-feedback">${LoginIsNotUnique}</div>

        </div>

        <div class="form-group">
            <label>Input your password</label>
            <input type="password" class="form-control" name="password" placeholder="password" required>
        </div>

        <div class="form-group">
            <label>Repeat your password</label>
            <input type="password" class="form-control" name="repeatPassword" placeholder="repeat password" required>
            <div class="invalid-feedback">${RepeatPasswordIsNotUnique}</div>
        </div>

        <button type="submit" class="btn btn-primary">Enter</button>
    </form>
</div>
</body>
</html>