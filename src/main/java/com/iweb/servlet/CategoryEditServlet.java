package com.iweb.servlet;

import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/12 9:14
 */
@WebServlet(urlPatterns = {"/editCategory"})
public class CategoryEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       获取参数id
        int id = Integer.parseInt(req.getParameter("id"));
//        根据id获取对应的分类信息
        Category category = new CategoryDAOImpl().get(id);
//        将数据设置在请求上
        req.setAttribute("category",category);
        //通过转发进行页面跳转和参数传递
        req.getRequestDispatcher("page/category/editCategory.jsp").forward(req,resp);
    }
}
