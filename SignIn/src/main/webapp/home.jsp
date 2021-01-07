<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body align = center>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <form action="/index" class="form-inline">
        <button type="submit" class="btn btn-success" name="form_auth_submit">Logout</button>
    </form>
</nav>
<div class="jumbotron text-center">
    <h1>WELCOME to home page!</h1>
    <p> Hello, ${login}</p>
    <c:if test ="${role eq 'ADMIN'}">
        <h1>Hello ADMIN!</h1>
        <p>We can put info for ADMIN here</p>
    </c:if>
    <c:if test ="${role eq 'USER'}">
        <h1>Hello USER!</h1>
        <p>We can put info for USER here</p>
    </c:if>

</div>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>Column 1</h3>
            <img width="300px" src="https://sun9-49.userapi.com/impg/qeDBaDKj9C2JzZXfgj7roGbbrsIKhPIk2g5nZw/rUzBSKKo4xw.jpg?size=500x500&quality=96&proxy=1&sign=e808f2bb58cde703192bdc6e9169b645&type=album">
        </div>
        <div class="col-sm-4">
            <h3>Column 2</h3>
            <img width="300px" src="https://sun9-24.userapi.com/impg/eMXc5fx8zLm6fd5gvfEveAEytNvzRexpzGLy0w/e9n0py1CGJY.jpg?size=679x480&quality=96&proxy=1&sign=eb75b4b462ee2558de6014bd06a5bbb5&type=album">
        </div>
        <div class="col-sm-4">
            <h3>Column 3</h3>
            <img width="300px" src="https://sun9-31.userapi.com/impg/AAny1KlKmM7p_1hYk3xyRryETw4baYzdHkA0LQ/KRa3f0klCLw.jpg?size=2001x1531&quality=96&proxy=1&sign=8154d58005761b3309da5ab693462ab8&type=album">
        </div>
    </div>

</div>



</body>
</html>