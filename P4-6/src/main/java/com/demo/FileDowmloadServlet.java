package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "FileDowmloadServlet")
public class FileDowmloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("LoggedIn") == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request,response);
            return;
        }
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data");
        File file = new File(dataDirectory,"Java.pdf");
        if (file.exists()){
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition","attachment;filename = Java.pdf");
        }
    }
}
