<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value="styles/login.css"/>">
</head>
<body>

<section>

    <form action="${pageContext.request.contextPath}/taxi" method="post">

        <div>
            <label for="userName"></label>
            <input type="text" id="userName" name="userName" placeholder="user name" required>
        </div>

        <div>
            <label for="passWord"></label>
            <input type="text" id="passWord" name="password" placeholder="pass word" required>
        </div>

        <input type="hidden" name="command" value="command_login">

        <div>
            <input type="submit" name="login" value="Login">
        </div>

    </form>

</section>

</body>
</html>
