<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="">
    <title>adminPage</title>
    <link rel="stylesheet" href="<c:url value="styles/administrator.css"/>">
</head>
<body>
<section>
    <form action="${pageContext.request.contextPath}/taxi" method="get">

        <input type="hidden" name="command" value="nearest_taxi_command">

        <div>
            <input type="submit" name="location" value="Orders">
        </div>
    </form>
</section>
</body>
</html>
