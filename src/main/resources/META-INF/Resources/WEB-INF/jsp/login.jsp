<html>
<head>
    <link href="../localhost:8080/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet" >
    <title> Login Page</title>
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <pre>${errorMessage}</pre>
    <form method="post">
        Name: <input type="text" name="name">
        Password: <input type="password" name="password">
        <input type="submit">
    </form>
</div>
<script src="../webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.6.1/jquery.min.js"></script>
</body>
</html>