<%@ page isELIgnored = "false" %>
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
            <div class="invalid-feedback">${WrongLoginOrPassword}</div>
        </div>
        <div class="form-group">
            <label>Input your password</label>
            <input type="password" class="form-control" name="password" placeholder="password" required>
        </div>

        <button type="submit" class="btn btn-primary" name="form_auth_submit">Enter</button>
        <a href="registration">Registration</a>
    </form>
</div>
</body>
</html>
