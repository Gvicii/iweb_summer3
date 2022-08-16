package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.ProductImageDAO;
import com.iweb.pojo.ProductImage;
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
        List<Product> products = new ProductDAO().list(cid);
        //根据pid 获取对应的图片集合
        //将每一个商品所对应的图片集合和商品本身进行绑定
        //引入dao
        ProductImageDAO imgdao = new ProductImageDAO();
        for (Product p :products) {
            int pid = p.getId();
            List<ProductImage> images = imgdao.select(pid);
            p.setImages(images);
        }
        //集合和cid存入到请求中
        req.setAttribute("products",products);
        req.setAttribute("cid",cid);
//        转发跳转
        req.getRequestDispatcher("page/product/listProduct.jsp").forward(req,resp);
    }
}
