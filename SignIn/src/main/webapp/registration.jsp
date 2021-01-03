<%@ page isELIgnored = "false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h2>SIGN IN!</h2>
    <form action="#" method="post">
        <div class="form-group">
            <label>Input your login</label>
            <input name="login" class="form-control" placeholder="login" >
        </div>

        <c:if test ="${LoginIsNotUnique = false}">
            <h1>Login should be unique</h1>
        </c:if>

        <div class="form-group">
            <label>Input your password</label>
            <input type="password" class="form-control" name="password" placeholder="password" >
        </div>
        <div class="form-group">
            <label>Repeat your password</label>
            <input type="password" class="form-control" name="repeatPassword" placeholder="repeat password" >
        </div>
        <button type="submit" class="btn btn-primary">Enter</button>
    </form>
</div>
</body>
</html>