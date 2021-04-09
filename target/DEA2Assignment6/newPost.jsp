<%@ page import="org.example.db.JDBCUtils" %>
<jsp:useBean id="user" class="org.example.beans.UserBean" scope="session"/>
<jsp:useBean id="discussion" class="org.example.beans.DiscussionBean" scope="page"/>
<jsp:setProperty name="discussion" property="*"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    discussion.addNewDiscussion(JDBCUtils.getLink(), user.getId());
    response.sendRedirect("discussions.jsp");

%>
</body>
</html>
