package com.demo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author Administrator
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        String uname = "admin";
        String psd = "admin";
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && username.equals(uname) &&  password != null  &&password.equals(psd)){
            message = "登录成功";
            HttpSession session = request.getSession(true);
            session.setAttribute("message",message);
            session.setAttribute("loginIn",Boolean.TRUE);
            response.sendRedirect("download.jsp");
            return;

        }else {
            message = "用户名或密码不正确";
            request.getSession().setAttribute("message",message);
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
