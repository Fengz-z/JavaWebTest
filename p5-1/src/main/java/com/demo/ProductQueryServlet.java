package com.demo;

import sun.security.mscapi.CPublicKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author SiriFeng
 */
@WebServlet("/query-product")
public class ProductQueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection dbconn = null;
    @Override
    public void init(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3308/webstore?useSSL=true";
        String username = "root";
        String password = "root";
        try {
            // 加载驱动程序
            Class.forName(driver);
            //创建连接对象
            dbconn = DriverManager.getConnection(dburl,username,password);
        }catch (ClassNotFoundException e1){
            System.out.println(e1);
            getServletContext().log("驱动程序未找到！");
        }catch (SQLException e2){
            System.out.println(e2);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productid = request.getParameter("productid");
        try {
            String sql = "SELECT * FROM products WHERE id = ? ";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,productid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()){
                Product product = new Product();
                product.setId(rst.getInt("id"));
                product.setPname(rst.getString("pname"));
                product.setBrand(rst.getString("brand"));
                product.setPrice(rst.getFloat("price"));
                product.setStock(rst.getInt("stock"));
                request.getSession().setAttribute("product",product);
                response.sendRedirect("/displayProduct.jsp");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void destory(){
        try {
            dbconn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Product> productList = new ArrayList<Product>();
        try{
            String sql = "SELECT * FROM products";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next()){
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setBrand(result.getString("brand"));
                product.setPname(result.getString("pname"));
                product.setPrice(result.getFloat("price"));
                product.setStock(result.getInt("stock"));
                productList.add(product);
            }
            if (!productList.isEmpty()){
                request.getSession().setAttribute("productList",productList);
                response.sendRedirect("/error.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
