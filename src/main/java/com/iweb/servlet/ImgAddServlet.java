package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.ProductImageDAO;
import com.iweb.pojo.ProductImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/15 16:08
 */
@WebServlet(urlPatterns = {"/addImg"})
public class ImgAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取参数
        int pid = Integer.parseInt(req.getParameter("pid"));
        String url = req.getParameter("url");
        //将获取的参数封装成Img对象
        ProductImage img = new ProductImage();
        img.setUrl(url);
        img.setP(new ProductDAO().get(pid));
        //调用DAO 数据入库
        new ProductImageDAO().add(img);
        //重新访问listImg 刷新页面
        resp.sendRedirect("/listImg?id=" + pid);
    }
}
