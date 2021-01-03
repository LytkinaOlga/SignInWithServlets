<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body align = center>
<h2>WELCOME!</h2>
<p> Hello, ${login}</p>
<c:if test ="${role eq 'ADMIN'}">
    <h1>Hello ADMIN!!!!!!!!!!!!</h1>
</c:if>
<c:if test ="${role eq 'USER'}">
    <h1>Hello USER!!!!!!!!!!!!</h1>
</c:if>

<form action="/index">
    <input type="submit" value="Logout"/>
</form>

</body>
</html>