package org.example.beans;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscussionBean implements Serializable {

    private Long id = null;
    private String subtext = null;
    private String title = null;
    private Long user_id = null;

    public DiscussionBean() {
    }

    public List<DiscussionBean> findAll(String url) throws ClassNotFoundException, SQLException {

        List<DiscussionBean> discussionBeans = new ArrayList<>();

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);
        PreparedStatement preparedStatement = null;

         preparedStatement = connection.prepareStatement("SELECT * FROM discussions ORDER BY id asc");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            DiscussionBean discussionBean = new DiscussionBean();

            discussionBean.setId(resultSet.getLong("id"));
            discussionBean.setTitle(resultSet.getString("title"));
            discussionBean.setSubtext(resultSet.getString("subtext"));
            discussionBean.setUser_id(resultSet.getLong("user_id"));

            discussionBeans.add(discussionBean);
        }
//        System.out.println(discussionBeans);

        return discussionBeans;

    }



    public Integer findDiscussionLikes(String url, Long discussion_id) throws ClassNotFoundException, SQLException {
        List<LikeBean> likeBeans = new ArrayList<>();

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM discussionlikes  WHERE discussion_id=? ORDER BY discussion_id asc");

        preparedStatement.setLong(1, discussion_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            LikeBean likeBean = new LikeBean();

            likeBean.setId(resultSet.getLong("id"));
            likeBean.setDiscuss_id(resultSet.getLong("discussion_id"));
            likeBean.setUser_id(resultSet.getLong("user_id"));

            likeBeans.add(likeBean);

        }

        return likeBeans.size();

    }

    public void addLike(String url, Long discussion_id, Long user_id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);
//        PreparedStatement preparedStatement = null;

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO discussionlikes(user_id, discussion_id) VALUES (?,?)");
        preparedStatement.setLong(1, user_id);
        preparedStatement.setLong(2,discussion_id);
        preparedStatement.executeUpdate();
    }



    public void addNewDiscussion(String url, Long user_id) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO discussions(title, subtext, user_id) VALUES(?, ?, ?)");

        preparedStatement.setString(1, title);
        preparedStatement.setString(2, subtext);
        preparedStatement.setLong(3, user_id);

        preparedStatement.executeUpdate();
    }

    public boolean likedByMeOrNot(String url, Long discussion_id, Long user_id) throws SQLException, ClassNotFoundException {

        List<LikeBean> likeBeans = new ArrayList<>();

        boolean likedByMe = true;

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);

        PreparedStatement  preparedStatement = connection.prepareStatement("SELECT * FROM discussionlikes WHERE user_id = ? and discussion_id = ?  ");

        preparedStatement.setLong(1, user_id);
        preparedStatement.setLong(2, discussion_id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            LikeBean likeBean = new LikeBean();
            likeBean.setId(resultSet.getLong("id"));
            likeBean.setUser_id(resultSet.getLong("user_id"));
            likeBean.setDiscuss_id(resultSet.getLong("discussion_id"));

            likeBeans.add(likeBean);

        }

        if (likeBeans.isEmpty()){
            likedByMe = false;
        }
        System.out.println(likedByMe);
        return likedByMe;
    }

    public Integer findDiscussionComments(String url, Long discussion_id) throws SQLException, ClassNotFoundException {

        List<CommentBean> commentBeans = new ArrayList<>();

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comments WHERE discussion_id=? ORDER BY discussion_id asc");

        preparedStatement.setLong(1, discussion_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            CommentBean commentBean = new CommentBean();

            commentBean.setId(resultSet.getLong("id"));
            commentBean.setContent(resultSet.getString("content"));
            commentBean.setDiscussion_id(resultSet.getLong("discussion_id"));
            commentBean.setUser_id(resultSet.getLong("user_id"));

            commentBeans.add(commentBean);
        }

        return commentBeans.size();

    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}

