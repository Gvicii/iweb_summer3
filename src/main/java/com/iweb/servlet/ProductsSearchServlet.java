package com.iweb.servlet;

import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Product;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/15 11:23
 */
@WebServlet(urlPatterns = {"/searchProducts"})
public class ProductsSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取所有商品的集合
        List<Product> products = new ProductDAOImpl().list();
//        将获取到的商品对象集合转换成一个JSON字符串
        String result = JSONSerializer.toJSON(products).toString();
           //中文处理
        resp.setContentType("text/html;charset=utf-8");
        //内容写入响应
        resp.getWriter().print(result);
    }
}
