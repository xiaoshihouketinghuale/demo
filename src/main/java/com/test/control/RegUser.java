package com.test.control;



import com.test.dao.DBOper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="RegUser", urlPatterns = "/test/RegUser")
//@MultipartConfig
public class RegUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String usercode = req.getParameter("usercode");
        String pwd = req.getParameter("pwd");
        boolean b =false;
        b = new DBOper().isReg(usercode);
        if (b){
            out.println("此账号已经被注册！");
            return;
        }
        b = new DBOper().RegUsers(name, usercode, pwd);
        if (b) {
            out.println("注册成功");
//            resp.sendRedirect("/Login.html");//重定向到登录页面
//            resp.sendRedirect("file:///E:/360%E5%AE%89%E5%85%A8%E6%B5%8F%E8%A7%88%E5%99%A8%E4%B8%8B%E8%BD%BD/tpmo_510_letter/tpmo_510_letter/copy.html");//重定向到登录页面
            resp.sendRedirect("/copy.html");
        }

    }
}

