package com.sirifeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ElServlet", urlPatterns = {"/show-el1"})
public class ElServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String [] arrs = new String[]{"林圣杰","雷小桥","何法霖","徐伟杰"};
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        request.setAttribute("arrs",arrs);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/demo1_table.jsp").forward(request,response);

    }
}
