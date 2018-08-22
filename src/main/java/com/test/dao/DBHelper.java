package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/servlet?useSSL=false";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "123456";

    public Connection conn = null;
    public PreparedStatement pst = null;
    //静态代码块
    static {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public DBHelper(){}

    public DBHelper(String sql) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
    public void close(){
        try {
            this.pst.close();
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}