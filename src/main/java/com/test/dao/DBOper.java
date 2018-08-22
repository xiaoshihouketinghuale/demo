package com.test.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOper {

    public boolean isUpload(String  name,String path) {
        boolean bok = false;
        int num =0;
        Connection conn = new DBHelper().getConn();
        String sql = "insert into updownload(name,path) values(?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i = 1;
            pstmt.setString(i++, name);
            pstmt.setString(i++, path);

            num = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean b = num == 0 ? (bok = false) : (bok = true);
        return bok;
    }

    //注册
    public boolean RegUsers(String name, String usercode, String pwd) {
        boolean bok =false;
        int num =0;
        Connection conn = new DBHelper().getConn();
        String sql = "insert into account(username,usercode,pwd) values(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i = 1;
            pstmt.setString(i++, name);
            pstmt.setString(i++, usercode);
            pstmt.setString(i++, pwd);

            num = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean b = num == 0 ? (bok = false) : (bok = true);
        return bok;
    }

    //判断账号是否存在
    public boolean isReg(String usercode) {
        boolean b = false;
        Connection conn = new DBHelper().getConn();
        String sql = "select usercode from account where usercode =?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i =1;
            pstmt.setString(i++, usercode);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                b = true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    //登录
    public boolean login(String usercode, String pwd) {
        boolean a = false;
        Connection conn = new DBHelper().getConn();
        String sql = "select * from account where usercode=? and pwd=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i = 1;
            pstmt.setString(i++, usercode);
            pstmt.setString(i++, pwd);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                a=true;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}