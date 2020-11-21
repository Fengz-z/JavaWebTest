package com.demo.controller;

import com.demo.GetSqlSession;
import com.demo.entity.Book;
import com.demo.dao.BookDao;
import com.demo.dao.impl.BookDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

/**
 * @author SiriFeng
 */
@WebServlet(name = "AddBookServlet", urlPatterns = {"/addBookServlet"})
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String isbn = request.getParameter("isbn");
        String title = new String(request.getParameter("title").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        float price = Float.parseFloat(request.getParameter("price"));
        String message;

        Book book = new Book(isbn, title, price);
        BookDao bookDao = new BookDaoImpl();

        try {
            bookDao.addBook(book);
            GetSqlSession.commit();
            message = "添加图书成功";
            request.setAttribute("message",message);
            request.getRequestDispatcher("add-book.jsp").forward(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }






    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
