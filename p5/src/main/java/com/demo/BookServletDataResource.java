package com.demo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Administrator
 */
@WebServlet(name = "BookServletDataResource", urlPatterns = {"/add-book2"})
public class BookServletDataResource extends HttpServlet {
    private static Connection dbconn = null;
    private static DataSource dataSource;
    PreparedStatement pstmt;

     synchronized public static Connection getConnection() {
         try {
             Context context = new InitialContext();
             dataSource = (DataSource)context.lookup("java:comp/env/jdbc/webstoreDS");
             dbconn = dataSource.getConnection();

         } catch (SQLException | NamingException throwables) {
             throwables.printStackTrace();
         }
         return dbconn;
     }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


        String isbn = request.getParameter("isbn");
        String title = new String(request.getParameter("title").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        float price = Float.parseFloat(request.getParameter("price"));
        String message = "";
        try {
            String sql = "INSERT INTO webstore.books VALUES(?,?,?)";
            pstmt =BookServletDataResource.getConnection().prepareStatement(sql);
            try {

                pstmt.setString(1, isbn);
                pstmt.setString(2, title);
                pstmt.setFloat(3, price);

                int num = pstmt.executeUpdate();

                if (num == 1) {
                    message = "插入记录成功";
                } else {
                    message = "插入记录失败";
                }
                request.setAttribute("message", message);
                request.getRequestDispatcher("add-book.jsp").forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
