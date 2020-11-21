package com.demo;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author Administrator
 */
@WebServlet(name = "FileDownloadServlet" , urlPatterns = {"/DownloadServlet"})
public class FileDownloadServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         * 1. 要获取下载文件的路径
         * 2. 下载的文件名是啥
         * 3. 设置想办法让浏览器能够支持下载我们需要的东西
         * 4. 获取下载文件的输入流
         * 5. 创建缓冲区
         * 6. 获取OutputStream对象
         * 7. 将FileOutPutStream流写入到buffer缓冲区
         * 8. 使用OutPutStream将缓冲区中的数据输出到客户端
         * */

        //1.获取下载文件的路径
        //ServletContext servletContext = this.getServletContext();
        //String realPath1 = servletContext.getRealPath();

        String realPath = "E:\\Learn\\Java\\Practice\\FileDownload\\src\\main\\webapp\\servlet-spec.pdf";

        //2.下载的文件名是什么
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //3.设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西
        response.setHeader("Content-Disposition", "attachment;filename" + URLEncoder.encode(fileName, "UTF-8"));
        //4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5.创建缓冲区
        int len;
        byte[] buffer = new byte[1024];
        //6.获取OutputStream对象
        ServletOutputStream out = response.getOutputStream();
        //7.将FileOutPutStream溢写入到buffer缓冲区，使用OutPutStream将缓冲区的数据输出到客户端
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }


}

