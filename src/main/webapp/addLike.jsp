<%@ page import="org.example.db.JDBCUtils" %>

<jsp:useBean id="user" class="org.example.beans.UserBean" scope="session"/>
<jsp:useBean id="discussion" class="org.example.beans.DiscussionBean" scope="page"/>
<jsp:useBean id="like" class="org.example.beans.LikeBean" scope="page"/>
<jsp:setProperty name="like" property="*"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    System.out.println(like.getUser_id() + "ds " + like.getDiscuss_id());
    discussion.addLike(JDBCUtils.getLink(), like.getDiscuss_id(),  like.getUser_id() );
    response.sendRedirect("discussions.jsp");

%>
</body>
</html>
