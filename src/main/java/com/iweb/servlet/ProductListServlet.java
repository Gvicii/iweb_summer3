package com.iweb.servlet;

import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/12 11:50
 */
@WebServlet(urlPatterns = {"/listProduct"})
public class ProductListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        int cid = Integer.parseInt(req.getParameter("id"));
        //调用DAO获取集合
        List<Product> products = new ProductDAOImpl().list(cid);
        //集合和cid存入到请求中
        req.setAttribute("products",products);
        req.setAttribute("cid",cid);
//        转发跳转
        req.getRequestDispatcher("page/product/listProduct.jsp").forward(req,resp);
    }
}
