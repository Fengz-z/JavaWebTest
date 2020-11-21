package com.sirifeng;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ControllerServlet",urlPatterns = {"/addToCart","/viewProductDetails","/deleteItem"})
public class ControllerServlet extends HttpServlet {
    
    ServletContext context;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int priductId = 0;
        int quantity = 0;
        try {
            priductId = Integer.parseInt(request.getParameter("id"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
            
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        Product product = getProduct(priductId);
        if (product != null && quantity >= 0){
            GoodItem goodItem = new GoodItem(product,quantity);
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
            if (cart == null){
                cart = new ShoppingCart();
                session.setAttribute("cart",cart);
            }
            cart.add(goodItem);
        }
        response.sendRedirect("showCart.jsp");
    }

    private Product getProduct(int priductId) {
        context = getServletContext();
        ArrayList<Product> products = (ArrayList<Product>) context.getAttribute("productList");
        for (Product product: products){

            if (product.getId() == priductId){
                return product;
            }

        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.endsWith("/viewProductDetails")){
            showProductDetails(request,response);
        }else if (uri.endsWith("deleteItem")){
            deleteItem(request,response);
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session =request.getSession();
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            GoodItem item = null;
            for (GoodItem shopItem : cart.getItems()){
                if (shopItem.getProduct().getId() == id){
                    item = shopItem;
                    break;
                }
            }
            assert item != null;
            cart.remove(item.getProduct().getId());
        }catch (NumberFormatException e){
            System.out.println("发生异常: " + e.getMessage());
        }
        session.setAttribute("cart",cart);
        response.sendRedirect("showCart.jsp");
    }


    private void showProductDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = 0;

        try {
            productId = Integer.parseInt(request.getParameter("id"));

        }catch (NumberFormatException e){

            System.out.println(e);
        }
        Product product = getProduct(productId);
        if (product != null){
            HttpSession session = request.getSession();
            session.setAttribute("product",product);
            response.sendRedirect("showProduct.jsp");
        } //

    }

}
