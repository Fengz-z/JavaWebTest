package com.demo.controller;

import com.demo.GetSqlSession;
import com.demo.dao.BookDao;
import com.demo.dao.impl.BookDaoImpl;

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
@WebServlet(name = "DeleteBookServlet",urlPatterns = {"/deleteBookServlet"})
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String isbn = request.getParameter("isbn");

        BookDao bookDao = new BookDaoImpl();

        try {
            bookDao.deleteBook(isbn);
            GetSqlSession.commit();
            response.sendRedirect("/findAll");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
