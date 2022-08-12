package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.impl.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/12 13:53
 */
@WebServlet(urlPatterns = {"/deleteProduct"})
public class ProductDeleteServlet extends HttpServlet {
    private static ProductDAO dao = new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //从请求中获取参数id
        int pid = Integer.parseInt(req.getParameter("id"));
        //先根据pid获取该商品对应的cid
        int cid = dao.get(pid).getCid();
        //调用dao删除对应的商品
        dao.delete(pid);
        //重定向到/listProduct 并且在发送请求的时候携带参数id
        //这样在listProduct运行的时候 才知道访问那个分类的商品列表
        resp.sendRedirect("/listProduct?id="+cid);

    }
}
