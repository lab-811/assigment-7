<%@ page import="org.example.db.JDBCUtils" %>
<jsp:useBean id="user" class="org.example.beans.UserBean" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<html>
<head>
    <title>Login</title>

</head>
<body>

<%

    if (user.login(JDBCUtils.getLink()))
        response.sendRedirect("discussions.jsp");
    else
        response.sendRedirect("login.html");

%>

</body>
</html>
