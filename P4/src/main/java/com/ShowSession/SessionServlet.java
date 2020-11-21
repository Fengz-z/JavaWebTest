package com.ShowSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author SiriFeng
 */
@WebServlet(name = "SessionServlet", urlPatterns = {"/ShowSession/SessionServlet"})
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建session，将localDate存放在session中
        HttpSession session = request.getSession(true);
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = dtf2.format(localDate);
        session.setAttribute("time",time);
        request.getRequestDispatcher("/ShowSession/show-session.jsp").forward(request,response);
    }
}
