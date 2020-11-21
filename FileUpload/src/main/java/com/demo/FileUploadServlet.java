package com.demo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
@MultipartConfig(location = "E:\\",fileSizeThreshold = 1024)
public class FileUploadServlet extends HttpServlet {
/*
    //返回上传来的文件名
    private String getFilename(Part part){
        String fname = null;
        //返回上传的文件部分的content-dispositon请求头的值
        String header = part.getHeader("content-disposition");
        //利用UUID生成伪随机字符串，作为文件名避免重复
        String uuid= UUID.randomUUID().toString();
        //获取文件后缀名
        fname = header.substring(header.lastIndexOf("."));
        fname = uuid+fname;
        return fname;
    }
*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String message = "";
        try {
            //创建解析工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //内存缓冲区的大小，默认值为10K

            //创建解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件的中文名称的中文乱码问题，设置解析器的编码，到底设什么编码，也不能瞎写，一定要看表单的数据是以什么编码提交的！
            upload.setHeaderEncoding("UTF-8");

            //调用解析器解析request，得到保存了所有上传数据的List集合
            List<FileItem> list = upload.parseRequest(request);
            //迭代List集合，拿到封装了每一个输入项数据的FileItem对象
            for (FileItem item : list) {
                //判断FileItem的类型，如果是普通字段，则直接获取数据，如果是上传文件，则调用流获取数据写到本地硬盘
                if (item.isFormField()) {
                    //为普通输入项的数据
                    String inputName = item.getFieldName();
                    String inputValue = item.getString();
                    System.out.println(inputName + "=" + inputValue);
                } else {
                    //代表当前处理的item里面封装的是上传文件
                    //IE6浏览器获取到的上传文件的名称是D:\a.txt；而IE7则是a.txt
                    String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
                    InputStream in = item.getInputStream();
                    int len = 0;
                    byte[] buffer = new byte[1024];

                    FileOutputStream out = new FileOutputStream("E:\\uploadTemp\\" + filename);
                    while ((len = ((InputStream) in).read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    message = "文件上传成功";
                    request.setAttribute("message",message);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fileUpload.jsp");
                    requestDispatcher.forward(request,response);
                    out.close();
                    in.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }










/*
        //返回Web应用程序文档根目录
        String path = this.getServletContext().getRealPath("/FileUpload");
        String mnumber = request.getParameter("mnumber");
        Part p = request.getPart("fileName");
        String message = "";
        //上传的文件不能超过1MB
        if (p.getSize() > 1024 * 1024){
            p.delete();
            message = "文件太大，不能上传";
        }else {
            //文件存储在文档根目录下的member子目录中会员号子目录中
            path = path + "\\member" + mnumber;
            File f = new File(path);
            //若目录不存在，则创建目录
            if ( !f.exists()){
                f.mkdirs();
            }
            //得到文件名
            String fname = getFilename(p);

            //将上传的文件写入磁盘
            p.write(path + "\\" + fname);
            message = "文件上传成功";
        }
        request.setAttribute("message",message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fileUpload.jsp");
        requestDispatcher.forward(request,response);

*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
