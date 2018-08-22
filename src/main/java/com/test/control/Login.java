package com.test.control;


import com.test.dao.DBOper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
/*    private void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            String requestURI = request.getRequestURI();
            String method = request.getMethod();
            String param = request.getParameter("param");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!doctype html5>");
            out.println("<html>");
            out.println("<head><title>登录界面</title></head>");
            out.println("<body>");
//            out.println("以" + method + "方式访问该页面，取到的param参数为：" + param + "<br/>");
            out.println("<form action='"+requestURI+"' method ='post'>"+"<input type ='text' name='usercode'>账号</br>");
            out.println("<input type ='password' name='pwd'>密码</br>");
            out.println("<input type ='submit' value='登录'></form>");
            out.println("<script>document.write('本页面最后更新时间：' + document.lastModified);</script>");

            out.println("</body>");
            out.println("</html>");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String usercode = request.getParameter("usercode");
        String pwd = request.getParameter("pwd");
        PrintWriter out = response.getWriter();

        boolean b = new DBOper().login(usercode, pwd);
        if (b) {
            response.sendRedirect("/Main.html");
        }else
            response.sendRedirect("/error.html");

    }
}
