package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.ProductDAO;
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
    private static ProductDAO dao = new ProductDAO();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        参数获取 封装对象 调用DAO
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String subTitle = req.getParameter("subTitle");
        float originalPrice = Float.parseFloat(req.getParameter("originalPrice"));
        float promotePrice = Float.parseFloat(req.getParameter("promotePrice"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        int cid = Integer.parseInt(req.getParameter("cid"));
        //将数据封装在对象中
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setSubTitle(subTitle);
        p.setOriginalPrice(originalPrice);
        p.setPromotePrice(promotePrice);
        p.setStock(stock);
        p.setCategory(new CategoryDAO().get(cid));
        //数据入库
        dao.update(p);
        
        //返回页面
        resp.sendRedirect("/listProduct?id="+cid);

    }
}
