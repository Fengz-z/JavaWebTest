package com.GuessNumber;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author SiriFeng
 */
@WebServlet(name = "GuessNumberServlet" , urlPatterns = {"/GuessNumber/GuessNumberServlet"})
public class GuessNumberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成随机数存放在session中
        doGet(request,response);
        //EL表达式提示信息
        String message = "";
        //获取用户猜的数
        int guess = Integer.parseInt(request.getParameter("guess"));

        //从会话对象中取出随机生成的数
        HttpSession session = request.getSession();
        int magic = (int) session.getAttribute("magic");

        if (guess == magic ){
            //猜对则销毁会话对象
            session.invalidate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/GuessNumber/guess-is-right.jsp");
            requestDispatcher.forward(request,response);

        }
        if (guess > magic){
            message = "猜大了哦";
            request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/GuessNumber/guess-number.jsp");
            requestDispatcher.forward(request,response);
        }
        if (guess < magic){
            message = "猜小了哦";
            request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/GuessNumber/guess-number.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("magic")==null)
        {
            //生成随机数
            int magic = (int) (Math.random()*101);
            //将生产的随机数magic存储到session中
            session.setAttribute("magic",magic);
        }

    }
}
