package com.sirifeng.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DealServlet" , urlPatterns = {"/DealServlet"})
public class DealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset = utf-8");
        request.setCharacterEncoding("utf-8");
        Student student =(Student)request.getAttribute("Student");
        PrintWriter out = response.getWriter();
        out.println("姓名："+new String(student.getName().getBytes(),"utf-8")+"<br>");
        out.println("学号:"+student.getSno()+"<br>");
        out.println("<a href = 'input.jsp'>返回登录页面</a>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
