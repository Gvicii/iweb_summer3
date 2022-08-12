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
 * @date 2022/8/12 14:39
 * @description 类的描述和介绍
 */
@WebServlet(urlPatterns = {"/updateProduct"})
public class ProductUpdateServlet  extends HttpServlet {
    private static ProductDAO dao = new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        参数获取
        int pid = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        int cid = Integer.parseInt(req.getParameter("cid"));
        //对象封装
        Product p = new Product();
        p.setId(pid);
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setCid(cid);
        //调用dao进行修改
        dao.update(p);
        //返回页面
        resp.sendRedirect("/listProduct?id="+cid);

    }
}
