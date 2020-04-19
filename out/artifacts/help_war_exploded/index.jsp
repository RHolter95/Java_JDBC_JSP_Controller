<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>SQL Login</title>

    Example: jdbc:mysql://localhost:3306/project4 <br>
    root:cgs254518!*<br><br>

    <form action="SQLServlet" method="POST">
        Enter SQL Server Address : <input type = "text" name = "SQLAddress"><br>
        Enter SQL Server Username : <input type = "text" name = "SQLUser"><br>
        Enter SQL Server Password : <input type = "text" name = "SQLPass"><br>
        <input type="submit"></input>
    </form><br><br><br>
</head>
<body>
</body>
</html>
