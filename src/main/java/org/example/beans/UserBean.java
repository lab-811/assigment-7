package org.example.beans;

import java.io.Serializable;
import java.sql.*;

public class UserBean implements Serializable {

    private Long id = null;
    private String password = null;
    private String name = null;


    private boolean amILogin = false;


    public UserBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAmILogin() {
        return amILogin;
    }

    public void setAmILogin(boolean amILogin) {
        this.amILogin = amILogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public boolean login(String url) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name=? and password=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {

            amILogin = true;
            id = rs.getLong("id");
        } else {
            amILogin = false;
        }

        return amILogin;
    }

    public void logOut(){
        amILogin = false;
    }


}
























