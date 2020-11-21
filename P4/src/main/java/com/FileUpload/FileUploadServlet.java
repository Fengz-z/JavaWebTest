package com.FileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @author SiriFeng
 */
@MultipartConfig(location = "E:\\",fileSizeThreshold = 1024)
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUpload/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    private String getFilename(Part part){
        String filename = null;
        //返回上传的文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        //返回不带路径的文件名
        filename = header.substring(header.lastIndexOf("."),header.length()-1);
        return filename;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回web应用文档根目录
        String path = this.getServletContext().getRealPath("/");
        String mnumber = request.getParameter("mnumber");
        Part part = request.getPart("filename");
        String message = "";
        //上传的文件不能超过1MB
        if (part.getSize()>1024*1024){
            part.delete();
            message = "文件太大，不能上传";
        }else {
            //文件存储在文档根目录下member子目录中会员号子目录中
            path = path +"\\" + mnumber;
            File file = new File(path);
            //若目录不存在，则创建目录
            if (!file.exists()){
                file.mkdirs();
            }
            //获得文件名
            String filename = getFilename(part);
            part.write(path+ "\\" + filename);
            message = "文件上传成功";
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("/FileUpload/file-upload.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
