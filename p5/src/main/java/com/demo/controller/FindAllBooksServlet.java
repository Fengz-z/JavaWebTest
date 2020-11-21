package com.demo.controller;

import com.demo.GetSqlSession;
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
import java.util.List;

@WebServlet(name = "FindAllBooksServlet",urlPatterns = {"/findAll"})
public class FindAllBooksServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        BookDao bookDao = new BookDaoImpl();
        try {
            List<Book> books = bookDao.findAll();
            GetSqlSession.rollback();

            request.setAttribute("books",books);
            request.getRequestDispatcher("show-book.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
