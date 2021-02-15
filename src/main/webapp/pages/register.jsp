<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="">
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value="styles/register.css"/>">
</head>
<body>
<section>

    <form action="${pageContext.request.contextPath}/taxi" method="post">

        <div class="divA">
            <label for="firstName"></label>
            <input type="text" id="firstName" name="firstName" placeholder="first name" required/>
        </div>

        <div class="divA">
            <label for="lastName"></label>
            <input type="text" id="lastName" name="lastName" placeholder="last name" required>
        </div>

        <div class="divA">
            <label for="phoneNumber"></label>
            <input type="text" id="phoneNumber" name="phoneNumber" placeholder="phone number" required>
        </div>

        <div class="divA">
            <label for="userName"></label>
            <input type="text" id="userName" name="userName" placeholder="user name" required>
        </div>

        <div class="divA">
            <label for="password"></label>
            <input type="text" id="password" name="password" placeholder="password" required>
        </div>

        <div class="divA">
            <label for="typeOfAccount"></label>
            <select id="typeOfAccount" name="typeOfAccount">
                <option value="CLIENT">Client</option>
                <option value="TAXI">Taxi</option>
            </select>
        </div>

        <input type="hidden" name="command" value="command_register">

        <div>
            <input type="submit" name="register" value="Register">
        </div>
    </form>

</section>
</body>