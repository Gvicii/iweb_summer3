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
 * @date 2022/8/15 15:42
 */
@WebServlet(urlPatterns = {"/listImg"})
public class ImgListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        int pid = Integer.parseInt(req.getParameter("id"));
        //根据id获取对应商品
        Product p =  new ProductDAO().get(pid);
        //根据pid获取关联的所有图片信息
        List<ProductImage> images = new ProductImageDAO().select(pid);
        //将图片集合存入到商品对象的images这个引用属性中
        p.setImages(images);
        //数据存入请求中
        req.setAttribute("p",p);
        //通过转发在跳转页面的同时 进行p的数据传递
        req.getRequestDispatcher("page/product/listImg.jsp").forward(req,resp);
    }
}
