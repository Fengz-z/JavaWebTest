package com.demo.controller;

import com.demo.dao.BookDao;
import com.demo.dao.impl.BookDaoImpl;
import com.demo.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author SiriFeng
 */
@WebServlet(name = "FindByIsbnServlet", urlPatterns = {"/findBook"})
public class FindByIsbnServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String isbn = request.getParameter("isbn");

        BookDao bookDao = new BookDaoImpl();
        try {
            Book book = bookDao.findBook(isbn);
            request.setAttribute("book",book);
            request.getRequestDispatcher("show-book1.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
