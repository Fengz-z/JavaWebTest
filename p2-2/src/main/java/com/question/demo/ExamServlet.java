package com.question.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class ExamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String quest1 = request.getParameter("q1");
        String quest2 = request.getParameter("q2");
        String[] quest3 = request.getParameterValues("q3");
        String quest4 = request.getParameter("q4").trim();

        int score = 0;

        if (quest1 != null && quest1.equals("3")) {
            score += 25;
        }

        if (quest2 != null && (quest2.equals("HttpServlet") || quest2.equals("javax.servlet.http.HttpServlet"))) {
            score += 25;
        }

        if (quest3 != null && quest3.length == 2 && quest3[0].equals("1") && quest3[1].equals("3")) {
            score += 25;
        }

        if (quest4 != null && quest4.equals("3")){
            score += 25;
        }

        out.println("<html><head>");
        out.println("<title>测试结果</title>");
        out.println("</head><body>");
        out.println("你的成绩是： " + score + "分");
        out.println("</body></html>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
