package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.impl.CategoryDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/12 8:50
 */
@WebServlet(urlPatterns = {"/deleteCategory"})
public class CategoryDeleteServlet extends HttpServlet {
    private static CategoryDAO dao = new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取参数id
        int id= Integer.parseInt(req.getParameter("id"));
        // 调用DAO实现删除
        dao.delete(id);
//        直接进行页面跳转 listCategory.jsp本身是没有数据的
        //发送 /listServlet的请求 让对应的servlet从数据库获取数据之后
        //转发跳转到listCategory.jsp
        resp.sendRedirect("/listCategory");

    }
}
