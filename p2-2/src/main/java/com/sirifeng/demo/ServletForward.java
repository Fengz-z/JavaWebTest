package com.sirifeng.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletForward" ,urlPatterns = {"/ServletForward"})
public class ServletForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        req.setCharacterEncoding("utf-8");
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        Student student = new Student(sname,sno);
        req.setAttribute("Student",student);
        PrintWriter out = resp.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("/DealServlet");
        rd.forward(req,resp);
    }
}
