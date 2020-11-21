package com.sirifeng;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class ProductContextListener implements ServletContextListener {

    private ServletContext context = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(new Product(101,"单反相机",4159.95,10,"尼康性价比最高的单反相机"));
        productList.add(new Product(102,"三星手机",1159.95,8,"晓龙865"));
        productList.add(new Product(103,"笔记本电脑",5159.95,20,"RTX 2080"));
        productList.add(new Product(104,"平板电脑",2159.95,20,"14英寸"));

        context = servletContextEvent.getServletContext();

        context.setAttribute("productList",productList);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        context = servletContextEvent.getServletContext();

        context.removeAttribute("productList");
    }
}
