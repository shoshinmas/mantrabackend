<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div>
    <h1>Your Todos lll</h1>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="../webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.6.1/jquery.min.js"></script>
</body>
</html>