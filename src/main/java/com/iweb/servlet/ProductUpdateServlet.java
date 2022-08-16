package com.iweb.servlet;

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
        // TODO: 2022/8/16
        
        //返回页面
//        resp.sendRedirect("/listProduct?id="+cid);

    }
}
