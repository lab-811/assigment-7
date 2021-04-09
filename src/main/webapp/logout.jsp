
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="user" class="org.example.beans.UserBean" scope="session" />
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    user.logOut();



    response.sendRedirect("index.jsp");
%>

</body>
</html>
