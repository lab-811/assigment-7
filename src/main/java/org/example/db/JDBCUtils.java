package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {


    public static String getLink(){
        return "jdbc:postgresql://localhost:5432/f_db?user=postgres&password=1234";
    }



}
