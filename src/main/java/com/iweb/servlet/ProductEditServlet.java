package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/12 14:22
 * @description 类的描述和介绍
 */
@WebServlet(urlPatterns = {"/editProduct"})
public class ProductEditServlet extends HttpServlet {
    private static ProductDAO dao = new ProductDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取要编辑的商品的id
        int pid = Integer.parseInt(req.getParameter("id"));
        //获取对应的商品对象
        Product p = dao.get(pid);
        //数据存入请求
        req.setAttribute("p", p);
        //通过转发跳转到editProduct.jsp
        req.getRequestDispatcher("page/product/editProduct.jsp").forward(req,resp);
    }
}
