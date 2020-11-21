package com.sirifeng;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet(name = "ProductServlet",urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"),"UTF-8");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id,name,price);
        request.setAttribute("product",product);
        RequestDispatcher rd = request.getRequestDispatcher("/display-product.jsp");
        rd.forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
