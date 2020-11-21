package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Administrator
 */
@WebServlet(name = "BookServlet",urlPatterns = {"/add-book"})
public class BookServlet extends HttpServlet {
    Connection dbconn = null;
    @Override
    public void init(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/webstore?useSSL=true&serverTimezone= GMT%2B8";
        String username = "root";
        String password = "root";
        try{
            try {
                Class.forName(driver);
                try {
                    dbconn = DriverManager.getConnection(dburl,username,password);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                getServletContext().log("驱动程序未找到！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String isbn = request.getParameter("isbn");
        String title = new String(request.getParameter("title").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        float price = Float.parseFloat(request.getParameter("price"));
        String message;
        try{
            String sql = "INSERT INTO BOOKS VALUES(?,?,?)";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            try {
                assert pstmt != null;
                pstmt.setString(1,isbn);
                pstmt.setString(2,title);
                pstmt.setFloat(3,price);

                int num = pstmt.executeUpdate();

                if (num==1){
                    message = "插入记录成功";
                }else {
                    message = "插入记录失败";
                }
                request.setAttribute("message",message);
                request.getRequestDispatcher("add-book.jsp").forward(request,response);
            } catch (SQLException throwables) {
                message = throwables.getMessage();
                request.setAttribute("message",message);
                request.getRequestDispatcher("add-book.jsp").forward(request,response);

            }
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
