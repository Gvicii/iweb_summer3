package com.iweb.servlet;



import com.iweb.dao.ProductImageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/15 16:14
 */
@WebServlet(urlPatterns = {"/deleteImg"})
public class ImgDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取要删除的图片id
        int id = Integer.parseInt(req.getParameter("id"));
        // 获取pid  用于后续的页面跳转
        int pid = Integer.parseInt(req.getParameter("pid"));
        //根据id删除对应的图片信息
        new ProductImageDAO().delete(id);
        //重新访问/listImg 获取页面最新信息
        resp.sendRedirect("/listImg?id=" + pid);
    }
}
