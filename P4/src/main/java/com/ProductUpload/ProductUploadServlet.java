package com.ProductUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author SiriFeng
 */
@MultipartConfig
@WebServlet(name = "ProductUploadServlet", urlPatterns = {"/ProductUpload/ProductUploadServlet"})
public class ProductUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //读取request中参数值
        String id = request.getParameter("id");
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        double price = Double.parseDouble(request.getParameter("price"));

        //Part对象用于接收上传文件
        Part part = request.getPart("photo");

        //路径：将文件存储到WEB-INF\images目录中
        String path = this.getServletContext().getRealPath("/images");
        File file = new File(path);

        if (!file.exists()){
            file.mkdirs();
        }
        String header = part.getHeader("content-disposition");
        String filename = header.substring(header.lastIndexOf(".",header.length()-1));

        //将文件写入磁盘
        part.write(path + "\\" + id + filename);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
